//package com.company;

import java.io.*;
import java.util.*;


public class PowersofTwo {
//public class Main {
    static ArrayList<Long> powerArray = new ArrayList<>();

    static void pow2gen() {
        long n = 1;
        int i=0;
        while (i<32) {
            powerArray.add(n *= 2);
            i++;
        }
    }

    public static void main(String[] args) throws IOException {
        InputReader sc = new InputReader();//( ╹▽╹ )
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));//start
        int n = sc.nextInt();
        pow2gen();
        long[] a = new long[n];
        Map<Long, Long> nc = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            Long count = nc.get(a[i]);
            if (count == null) {
                nc.put(a[i], 1L);
            } else {
                nc.put(a[i], count + 1);
            }
        }
        long cnt = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < powerArray.size(); j++) {
                long x = powerArray.get(j) - a[i];

                if (nc.containsKey(x)) {
                    if (x == a[i])
                        cnt += (nc.get(x) - 1);
                    else
                        cnt += nc.get(x);
                }
            }
        }


//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if(i==j)continue;
//                int x=a[i]+a[j];
//                if (x != 0 && ((x & (x - 1)) == 0)){
////                out.println(a[i]+" "+a[j]);
//                count++;
//                }
//            }               /tle answer
//
//        }
        out.println(cnt / 2);
        out.close();
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
