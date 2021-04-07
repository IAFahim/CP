//package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class robi3 {
//            public class Main {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    static void leftRotate(int arr[], int d, int n) {
        d = d % n;
        int i, j, k, temp;
        int g_c_d = gcd(d, n);
        for (i = 0; i < g_c_d; i++) {
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    static void shiftArrayOnePosition(int arr[], int size) {
        int i, temp;
        temp = arr[0];

        for (i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[i] = temp;
    }

    static void rotateArray(int arr[], int size, int N) {
        int i;
        for (i = 0; i < N; i++) {
            shiftArrayOnePosition(arr, size);
        }
    }

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int times = sc.nextInt(), ord = sc.nextInt(), rot = 1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (ord == 1) {
            int result[] = new int[n];
            int len = times % arr.length + ((times < 0) ? arr.length : 0);
            for (int i = len; i < arr.length; i++)
                result[i] = arr[i - len];

            for (int i = 0; i < len; i++)
                result[i] = arr[arr.length - len + i];
            for (int i = 0; i < arr.length-1; i++) {
                out.print(result[i] + " ");
            }
            out.print(result[n-1]+"");
        } else {
            leftRotate(arr, times, arr.length);
            for (int i = 0; i < arr.length-1; i++) {
                out.print(arr[i] + " ");
            }
            out.print(arr[n-1]+"");
        }


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
    // 4:15 PM Tue 12 2020 12/29/2020
}