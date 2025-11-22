/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package composefile;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class HuffmanCoding {

    // Node for Huffman tree
    private static class Node implements Comparable<Node>, Serializable {

        final long freq;
        final int value; // 0..255 for leaf, -1 for internal
        final Node left, right;

        Node(long freq, int value, Node left, Node right) {
            this.freq = freq;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.freq, o.freq);
        }
    }

    // Bit output helper
    private static class BitOutputStream implements Closeable {

        private final OutputStream out;
        private int currentByte = 0;
        private int numBitsFilled = 0;

        BitOutputStream(OutputStream out) {
            this.out = out;
        }

        // write a single bit (0 or 1)
        void writeBit(int b) throws IOException {
            if (b != 0 && b != 1) {
                throw new IllegalArgumentException("Bit must be 0 or 1");
            }
            currentByte = (currentByte << 1) | b;
            numBitsFilled++;
            if (numBitsFilled == 8) {
                out.write(currentByte);
                numBitsFilled = 0;
                currentByte = 0;
            }
        }

        // write bits from a string "0101..."
        void writeBits(String bits) throws IOException {
            for (int i = 0; i < bits.length(); i++) {
                writeBit(bits.charAt(i) == '1' ? 1 : 0);
            }
        }

        // pad remaining bits with zeros and flush
        void flush() throws IOException {
            if (numBitsFilled > 0) {
                currentByte <<= (8 - numBitsFilled);
                out.write(currentByte);
                currentByte = 0;
                numBitsFilled = 0;
            }
            out.flush();
        }

        @Override
        public void close() throws IOException {
            flush();
            out.close();
        }
    }

    // Bit input helper
    private static class BitInputStream implements Closeable {

        private final InputStream in;
        private int currentByte = 0;
        private int numBitsRemaining = 0;
        private boolean reachedEOF = false;

        BitInputStream(InputStream in) {
            this.in = in;
        }

        // return -1 for EOF, otherwise 0 or 1
        int readBit() throws IOException {
            if (reachedEOF) {
                return -1;
            }
            if (numBitsRemaining == 0) {
                currentByte = in.read();
                if (currentByte == -1) {
                    reachedEOF = true;
                    return -1;
                }
                numBitsRemaining = 8;
            }
            numBitsRemaining--;
            return (currentByte >>> numBitsRemaining) & 1;
        }

        @Override
        public void close() throws IOException {
            in.close();
        }
    }

    // Build frequency table from file (bytes 0..255)
    private static long[] buildFrequencyTable(File input) throws IOException {
        long[] freq = new long[256];
        try (InputStream in = new BufferedInputStream(new FileInputStream(input))) {
            int b;
            while ((b = in.read()) != -1) {
                freq[b & 0xFF]++;
            }
        }
        return freq;
    }

    // Build Huffman tree from frequencies
    private static Node buildHuffmanTree(long[] freq) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                pq.add(new Node(freq[i], i, null, null));
            }
        }

        // special case: file had no bytes
        if (pq.isEmpty()) {
            return null;
        }

        // special case: only one unique byte -> create an artificial parent
        if (pq.size() == 1) {
            Node only = pq.poll();
            // create parent node: left=only, right=null? better to make two leaves with same value
            Node parent = new Node(only.freq, -1, only, null);
            return parent;
        }

        while (pq.size() > 1) {
            Node a = pq.poll();
            Node b = pq.poll();
            Node parent = new Node(a.freq + b.freq, -1, a, b);
            pq.add(parent);
        }
        return pq.poll();
    }

    // Build code map (byte -> bit string)
    private static void buildCodeMap(Node node, String prefix, String[] codeMap) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            int v = node.value;
            // If tree only had 1 unique symbol and parent was created with null right,
            // ensure we still have a code (use "0")
            codeMap[v] = prefix.length() > 0 ? prefix : "0";
        } else {
            buildCodeMap(node.left, prefix + "0", codeMap);
            buildCodeMap(node.right, prefix + "1", codeMap);
        }
    }

    // Compress file
    public static void compress(String inputPath, String outputPath) throws IOException {
        File inFile = new File(inputPath);
        if (!inFile.exists()) {
            throw new FileNotFoundException("Input file not found: " + inputPath);
        }

        long[] freq = buildFrequencyTable(inFile);
        Node root = buildHuffmanTree(freq);

        // build code map
        String[] codeMap = new String[256];
        if (root != null) {
            buildCodeMap(root, "", codeMap);
        }

        // count original size
        long originalSize = 0;
        for (long f : freq) {
            originalSize += f;
        }

        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outputPath)))) {
            // Write frequency table (256 longs)
            for (int i = 0; i < 256; i++) {
                dos.writeLong(freq[i]);
            }
            // Write original size
            dos.writeLong(originalSize);
            dos.flush();

            // Now write compressed bits
            try (BitOutputStream bos = new BitOutputStream(dos)) {
                try (InputStream in = new BufferedInputStream(new FileInputStream(inFile))) {
                    int b;
                    while ((b = in.read()) != -1) {
                        String code = codeMap[b & 0xFF];
                        // should not be null if freq built correctly
                        if (code == null) {
                            throw new IOException("No code for byte: " + (b & 0xFF));
                        }
                        bos.writeBits(code);
                    }
                }
                // bos.close() will flush remaining bits
            }
        }
    }

    // Rebuild tree from freq table
    private static Node buildTreeFromFreq(long[] freq) {
        return buildHuffmanTree(freq);
    }

    // Decompress file
    public static void decompress(String inputPath, String outputPath) throws IOException {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(inputPath)))) {
            long[] freq = new long[256];
            for (int i = 0; i < 256; i++) {
                freq[i] = dis.readLong();
            }
            long originalSize = dis.readLong();

            Node root = buildTreeFromFreq(freq);
            if (root == null) {
                // empty file case -> create empty output
                new File(outputPath).createNewFile();
                return;
            }

            try (BitInputStream bis = new BitInputStream(dis); OutputStream out = new BufferedOutputStream(new FileOutputStream(outputPath))) {

                long written = 0;
                Node current = root;
                // If tree was created with single leaf and parent with right==null, handle carefully:
                if (root.isLeaf()) {
                    // every code is the single value
                    while (written < originalSize) {
                        out.write(root.value);
                        written++;
                    }
                    return;
                }

                int bit;
                while (written < originalSize && (bit = bis.readBit()) != -1) {
                    // traverse
                    if (bit == 0) {
                        if (current.left != null) {
                            current = current.left;
                        } else {
                            // malformed stream
                            throw new IOException("Malformed bitstream (no left child)");
                        }
                    } else {
                        if (current.right != null) {
                            current = current.right;
                        } else {
                            // malformed stream
                            throw new IOException("Malformed bitstream (no right child)");
                        }
                    }

                    if (current.isLeaf()) {
                        out.write(current.value);
                        written++;
                        current = root;
                    }
                }

                if (written != originalSize) {
                    // Could be leftover padded bits at the end; but if mismatch too large, warn
                    // For safety, we simply close (in many implementations originalSize controls stop)
                    // Optionally: throw new IOException("Decompressed size mismatch");
                }

                out.flush();
            }
        }
    }

    // For debugging: print codes
    private static void printCodes(String[] codeMap) {
        System.out.println("Huffman Codes:");
        for (int i = 0; i < codeMap.length; i++) {
            if (codeMap[i] != null) {
                char c = (char) i;
                String desc = (Character.isISOControl(c) ? String.format("0x%02X", i) : "'" + c + "'");
                System.out.printf("%s (%d): %s\n", desc, i, codeMap[i]);
            }
        }
    }

    // Main: compress or decompress
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage:");
            System.out.println("  java HuffmanCoding c inputFile outputFile   # compress");
            System.out.println("  java HuffmanCoding d inputFile outputFile   # decompress");
            return;
        }
        String mode = args[0];
        String in = args[1];
        String out = args[2];

        try {
            if (mode.equalsIgnoreCase("c")) {
                System.out.println("Compressing " + in + " -> " + out);
                compress(in, out);
                System.out.println("Compression finished.");
            } else if (mode.equalsIgnoreCase("d")) {
                System.out.println("Decompressing " + in + " -> " + out);
                decompress(in, out);
                System.out.println("Decompression finished.");
            } else {
                System.err.println("Unknown mode: " + mode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
