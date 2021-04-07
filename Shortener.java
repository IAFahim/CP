//package com.company;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

import static java.lang.Math.*;

public class Shortener {
    //    public class Main {
    static char map[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static Map<String, String> mp = new HashMap<>();
    static Map<String, String> pm = new HashMap<>();

    public static String getCharForNumber(int i) {
        StringBuilder str = new StringBuilder();
        while (0 < i) {
            str.append(map[i % map.length]);
            i /= map.length;
        }
        return str.toString();
    }

    public static String urlShortener(String longURL) {
        System.out.println("input__ " + longURL);
        if (!pm.containsKey(longURL)) {
            String shortURL = "short.ly/" + getCharForNumber(mp.size() + 1);
            mp.put(shortURL, longURL);
            pm.put(longURL, shortURL);
            System.out.println("output__" + shortURL.toString());
            return shortURL.toString();
        } else {
            System.out.println(longURL.toString());
            return pm.get(longURL);
        }
    }

    public static String urlRedirector(String shortURL) {
        System.out.println("input_ " + shortURL);
        String longURL = mp.get(shortURL);
        System.out.println("output_" + longURL);
        return longURL;
    }

    public static void main(String[] args) throws IOException {
        debug(urlShortener("https://www.codewars.com/kata/5ef9c85dc41b4e000f9a645f"));
        debug(urlShortener("https://www.codewars.com/kata/5ef9c85dc41b4e000f9a645f"));
        debug(urlRedirector("short.ly/a"));
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
    // 8:05 PM Fri 01 2021 1/8/2021
}