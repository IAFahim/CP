//package com.company;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

import static java.lang.Math.*;

public class NobodyKnowsBetterThanMe {
//            public class Main {
    public static class Pair implements Comparable<Pair> {
        int x;
        int y;
        int dif;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.dif = abs(x - y + 1) / 2;
        }

        public Pair clone() {
            return new Pair(x, y);
        }

        public String toString() {
            return x + " " + y;
        }

        @Override
        public int compareTo(Pair pair) {
            return dif - pair.dif;
        }
//        public int compareTo(Pair o) {
//            if (x > o.x) {
//                return 1;
//            }
//            if (x < o.x) {
//                return -1;
//            }
//            if (y > o.y) {
//                return 1;
//            }
//            if (y < o.y) {
//                return -1;
//            }
//            return 0;
//        }
    }

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt(), time = sc.nextInt();
        Pair arr[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            arr[i] = new Pair(a, b);
        }
        Arrays.sort(arr);
        //x==baiden
        //y==trump
        int trump = 0, bainden = 0;
//        debug(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i].x >= arr[i].y) {
                if (arr[i].x == arr[i].y) {
                    if (time > 0) {
                        time--;
                        trump++;
                    } else {
                        bainden++;
                    }
                } else {
                    if (time >= arr[i].dif) {
                        time -= arr[i].dif;
                        trump++;
                    } else {
                        bainden++;
                    }
                }
            } else {
                trump++;
            }
        }
        if (bainden > trump) {
            out.println("Fake Polls!");
        } else {
            out.println("Make Byteland Great Again!");
        }

        close.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj).replace("], ", "]\n"));
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
}