package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class PasswordMaker {
    //    public class Main {
    static char lowerarr[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static char upperarr[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static char numberarr[] = "0123456789".toCharArray();

    public static String shuffle(char[] str) {
        List<Character> characters = new ArrayList<Character>();
        for (char c : str) {
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(str.length);
        while (characters.size() != 0) {
            int randPicker = (int) (Math.random() * characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }

    public static String makePassword(int n, boolean Upper, boolean Lower, boolean Digit) {
        if (!(Upper | Lower | Digit) || n > 62)
            return "";
        char str[] = new char[n];
        int i = 0;
        List<Character> upperCase = new ArrayList<Character>();
        if (Upper && i < n) {
            for (char c : upperarr) {
                upperCase.add(c);
            }
            int x = (int) (Math.random() * upperCase.size());
            str[i++] = upperCase.remove(x);
        }
        List<Character> lowerCase = new ArrayList<Character>();
        if (Lower && i < n) {
            for (char c : lowerarr) {
                lowerCase.add(c);
            }
            int x = (int) (Math.random() * lowerCase.size());
            str[i++] = lowerCase.remove(x);
        }
        List<Character> numbers = new ArrayList<Character>();
        if (Digit && i < n) {
            for (char c : numberarr) {
                numbers.add(c);
            }
            int x = (int) (Math.random() * numbers.size());
            str[i++] = numbers.remove(x);
        }
        int ran = 0;
        while (i < n) {
            int at = (int) Math.ceil(Math.random() * 3);
            if (Lower && at < 2 && 0 < lowerCase.size()) {
                int x = (int) (Math.random() * lowerCase.size());
                str[i++] = lowerCase.remove(x);
            } else if (Upper && at == 2 && 0 < upperCase.size()) {
                int x = (int) (Math.random() * upperCase.size());
                str[i++] = upperCase.remove(x);
            } else if (Digit && 0 < numbers.size()) {
                int x = (int) (Math.random() * numbers.size());
                str[i++] = numbers.remove(x);
            }
            ran++;
        }
        return shuffle(str);
    }

    static void countDigits(long l) {
        if (l >= 10000000000L) System.out.println("The number is valid");
        else System.out.println("The number is invaild");
    }

    public static void main(String[] args) throws IOException {
        countDigits(1772527556L);
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
    // 12:08 AM Fri 02 2021 2/5/2021
}