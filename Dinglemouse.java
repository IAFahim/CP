//package com.company;

import java.awt.*;
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Dinglemouse {
    //    public class Main {

    public static class Point implements Comparable<Point> {
        double x;
        double y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y;
        }

        public String parallelLineEq(double abc[], double o_x, double o_y) {

            return toStringEq(abc);
        }

        public String straightLineEq(double o_x, double o_y) {
            double abc[] = ax_by__c(o_x, o_y);
            return toStringEq(abc);
        }

        public String toStringEq(double[] abc) {
            if (abc == null) return null;
            byte a = 0, b = 1, c = 2;
            boolean abcIsZero[] = new boolean[]{abc[a] == 0, abc[b] == 0, abc[c] == 0};
            if (abcIsZero[a] && abcIsZero[b] && abcIsZero[c]) {
                return null;
            }
            StringBuilder eq = new StringBuilder();
            if (!abcIsZero[b]) {
                eq.append("y = ");
                if (abcIsZero[a] && abcIsZero[c]) {
                    eq.append(0);
                }
            } else {
                if (!abcIsZero[c]) {
                    eq.append("x = " + (c / b));
                    return eq.toString();
                } else {
                    eq.append("0 = ");
                }
            }
            if (!abcIsZero[a]) {
                if (-a != 1 && !abcIsZero[b])
                    eq.append(-abc[a]);
                eq.append("x ");
            }
            if (!abcIsZero[c]) {
                if (0 < abc[c] && !abcIsZero[a])
                    eq.append("+");
                eq.append(abc[c]);
            }
            return eq.toString();
        }

        public double[] ax_by__c(double o_x, double o_y) {
            if (x == o_x && o_y == y) return null;
            double a = o_y - y, b = x - o_x, c = a * x + b * y;
            if (b != 0) {
                a = a / b;
                c = c / b;
                b = 1;
            }
            return new double[]{a, b, c};
        }


        public boolean equals(Point p) {
            return x == p.x && y == p.y;
        }

        public double dist2() {
            return x * x + y * y;
        }

        public double dist2Sq() {
            return Math.sqrt(x * x + y * y);
        }

        public double dist2(double o_x, double o_y) {
            double run = x - o_x;
            double rise = y - o_y;
            return run * run + rise * rise;
        }

        public double dist2Sq(double o_x, double o_y) {
            double run = x - o_x;
            double rise = y - o_y;
            return Math.sqrt(run * run + rise * rise);
        }

        public Point pol() {
            return new Point(dist2(), Math.atan2(y, x));
        }

        public Point pol(double o_x, double o_y) {
            return new Point(dist2(o_x, o_y), Math.atan2(y - o_y, x - o_x));
        }

        public Point polSq() {
            return new Point(dist2Sq(), (Math.atan2(y, x) * 180) / Math.PI);
        }

        public Point polSq(double o_x, double o_y) {
            return new Point(dist2Sq(o_x, o_y), (Math.atan2(y - o_y, x - o_x) * 180) / Math.PI);
        }

        public Point add(Point v) {
            return new Point(x + v.x, y + v.y);
        }

        static double eps = 1e-10;

        public int signum(double x) {
            if (x > eps) {
                return 1;
            }
            if (x < -eps) {
                return -1;
            }
            return 0;
        }

        @Override
        public int compareTo(Point o) {
            int z = signum(x + y - o.x - o.y);
            if (z != 0) {
                return z;
            }
            return signum(x - o.x) != 0 ? signum(x - o.x) : signum(y - o.y);
        }
    }


    public static void main(String[] args) throws IOException {
        Point base = new Point(10, 100);
        debug(base.straightLineEq(-10, 8));
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

    static Sc sc = new Sc();
    static Print out = new Print();
    static BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
    // 12:21 PM Wed 01 2021 1/6/2021
}