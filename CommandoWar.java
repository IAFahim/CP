//package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.security.KeyPair;
import java.util.*;

public class CommandoWar {
    //    public class Main {
    public static void main(String[] args) throws IOException {
        InputReader sc = new InputReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int i = 1;
        while (true) {
            int x = sc.nextInt();
            if (x == 0) break;
            ArrayList<Node> list = new ArrayList<Node>();
            for (int j = 0; j < x; j++) {
                list.add(new Node(sc.nextInt(),sc.nextInt()));
            }
            Collections.sort(list);
            int total=0,start=0;
            for (int j = 0; j < x; j++) {
                start+=list.get(j).brifing_time;
                total=Math.max(total,start+list.get(j).mining_time);
            }
            out.println("Case "+(i)+": "+total);
            i++;
        }
        out.close();
    }
    static class Node implements Comparable<Node> {
        int brifing_time;
        int mining_time;

        Node(int x, int y) {

            this.brifing_time = x;
            this.mining_time = y;
        }

        @Override
        public int compareTo(Node o) {
            int diff = o.mining_time - this.mining_time;
            return diff;
        }
    }
    //-----------PrintWriter for faster output---------------------------------
    static class InputReader {
        private byte[] buf = new byte[16384];
        private int curChar;
        private int numChars;

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = System.in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
//--------------------------------------------------------

}
