package com.company;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;

public class FindtheTownJudge {
    //    public class Main {
    static int SIZE = 1000;
    static boolean grid[][] = new boolean[SIZE][SIZE];

    static void printGraph() {
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).isEmpty()) continue;
            System.out.print(i + ": ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }
    static int start=0, end=grid.length, gap=1;
    static void printgrid() {
        System.out.print("  ");
        for (int i = start; i < grid.length && i < end; i += gap) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.println();
        for (int y = start; y < grid.length && y < end; y += gap) {
            System.out.print(y + " ");
            for (int x = start; x < grid[y].length && x < end; x += gap) {
                System.out.print((grid[y][x] ? " 1" : " 0"));
            }
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Integer>> adj;

    static void addEdge(int firstVertex, int lastVertex) {
        adj.get(firstVertex).add(lastVertex);
    }

    static void clearGraph() {
        adj = new ArrayList<ArrayList<Integer>>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            adj.add(new ArrayList<Integer>());
        }
    }

    static public int findJudge(int N, int[][] trust) {
        SIZE = N--;
        clearGraph();
        for (int y = 0; y < trust.length; y++) {
//            grid[trust[y][0] - 1][trust[y][1] - 1] = true;
            addEdge(trust[y][0] - 1, trust[y][1] - 1);
        }
//        printGraph();
//        printgrid();
        int max = 0, judge = 0;
        for (int i = 0; i < SIZE; i++) {
            boolean x = true;
            if (adj.get(i).size() == 0) {
                for (int j = 0; j < SIZE; j++) {
                    if (i == j) continue;
                    if (!adj.get(j).contains(i)) {
                        x = false;
                        break;
                    }
                }
                if (x) return ++i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        int x[][] = new int[][]{{1, 2}, {2, 3}};
        out.println(findJudge(3, x) + "");
        close.close();
    }

    static class Sc {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
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
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
                return true;
            return false;
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
}