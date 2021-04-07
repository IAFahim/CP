package com.company;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;

import javax.swing.tree.TreeNode;
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class FindMax {
    //    public class Main {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public static TreeNode leaf(int value) {
            TreeNode treeNode = new TreeNode();
            treeNode.value = value;
            return treeNode;
        }

        public TreeNode withLeaves(int left, int right) {
            TreeNode treeNode = this;
            treeNode.left = leaf(left);
            treeNode.right = leaf(right);
            return treeNode;
        }

        public static TreeNode join(int i, TreeNode left, TreeNode right) {
            TreeNode treeNode = leaf(i);
            treeNode.left = left;
            treeNode.right = right;
            return treeNode;
        }

        public static int findMax(TreeNode root) {
            if (root == null) {
                return Integer.MIN_VALUE;
            }
            return Math.max(Math.max(findMax(root.left), findMax(root.right)), root.value);
        }

        public static int Sum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return root.value + Sum(root.left) + Sum(root.right);
        }


        public static int peekSum(TreeNode root) {
            if (root.right == null) {
                return root.value;
            } else if (root.left == null) {
                return root.value;
            }
            return peekSum(root.right) + peekSum(root.left);
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public int getValue() {
            return value;
        }

        public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
            if(right!=null) {
                right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
            }
            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(String.valueOf(value)).append("\n");
            if(left!=null) {
                left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
            }
            return sb;
        }

        public void tostring() {
            System.out.println(this.toString(new StringBuilder(), true, new StringBuilder()).toString());
        }

    }


    public static void main(String[] args) throws IOException {
        TreeNode left = TreeNode.leaf(3);
        left.left = new TreeNode().leaf(2);
        TreeNode right = TreeNode.leaf(-10).withLeaves(16, 1);
        right.right.right = new TreeNode().leaf(13);
        TreeNode root = TreeNode.join(17, left, right);
        TreeNode.peekSum(root);
        root.tostring();
        close.close();
    }






















    /* This is O(scary), but seems quick enough in practice. */

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj).replace("], ", "]\n"));
    }

    static void debugV2(Object... obj) {
        System.out.println(Arrays.deepToString(obj)
                .replace("],", "\n").replace(",", "\t")
                .replaceAll("[\\[\\]]", " "));
    }

    static class Sc {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Sc() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Sc(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public String nextString() throws IOException {
            StringBuilder sb = new StringBuilder();
            int n = read();
            while (isWhiteSpace(n))
                n = read();
            while (!isWhiteSpace(n)) {
                sb.append((char) n);
                n = read();
            }
            return sb.toString();
        }

        private boolean isWhiteSpace(int n) {
            return n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }


    static class Print {
        private final OutputStream out;

        public Print() {
            this.out = System.out;
        }

        public void print(String str) throws IOException {
            for (int i = 0; i < str.length(); i++) {
                out.write(str.charAt(i));
            }
        }

        public void println(String str) throws IOException {
            print(str);
            out.write('\n');
        }

        public void close() throws IOException {
            out.close();
        }
    }

    static Sc sc = new Sc();
    static Print out = new Print();
    static BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
    // 3:20 PM Sat 01 2021 1/30/2021
}