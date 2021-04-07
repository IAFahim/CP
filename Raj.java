package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Raj {
    //        public class Main {

    static double f(long n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 3;
        }
        if (n > 2) {
            if (((n & 1) == 0)) {
                double fst = Math.sqrt(f(n - 1));
                double sec = Math.pow(f(n - 2), 1.0 / (n - 2));
                return fst + sec;
            } else {
                double trd = Math.pow(f(n - 1), 1.000001);
                return trd;
            }
        }
        return 0;
    }

    public static double F(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return n;
        }
        double fst = 3;
        if (n == 2) {
            return fst;
        }
        double sec = 3;
        for (double i = fst; i <= n; i++) {
            if (((long) i & 1) == 0) {
                fst = Math.sqrt(fst);
                sec = Math.pow(sec, (1 / (i - 2)));
            } else {
                if (i != 3) {
                    sec = fst += sec;
                }
                fst = Math.pow(fst, 1.000001);
            }
        }
        return ((n & 1) == 0) ? fst + sec : fst;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.next(),Der=sc.next();
        byte n=sc.nextByte();
        System.out.println(encoder(str, Der.equals("RIGHT") ? Direction.RIGHT : Direction.LEFT, n) + "");
    }

    enum Direction {
        LEFT,
        RIGHT
    }

    public static String encoder(String str, Direction shiftDirection, byte numberOfShift){
        StringBuilder arr=new StringBuilder();
        numberOfShift%=26;
        if(Direction.LEFT==shiftDirection){
            numberOfShift*=-1;
        }
        for (int i = 0; i < str.length(); i++) {
            if('A'<=str.charAt(i) && str.charAt(i)<='Z'){
                arr.append((char)(((str.charAt(i)-'A'+numberOfShift)%26)+'A'));
            }else if('a'<=str.charAt(i) && str.charAt(i)<='z'){
                arr.append((char)(((str.charAt(i)-'a'+numberOfShift)%26)+'a'));
            }
        }
        return arr.toString();
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
    // 2:59 PM Wed 03 2021 3/17/2021
}