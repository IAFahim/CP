//package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class ChefSwapsDigits {
//            public class Main {
    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        int till = sc.nextInt();
        for (int z = 0; z < till; z++) {
            int a = sc.nextInt(), b = sc.nextInt();
            int last_a, first_a, last_b, first_b, ans = 0;
            Integer comb[]={0,0,0,0};
            first_b = b / 10;
            last_b = b % 10;
            first_a = a / 10;
            last_a = a % 10;
            if (a < 10 && b < 10) {
                ans = a + b;
            } else {
                if (a < 10) {
                    comb[0] = first_b + last_a * 10 + last_b;
                    comb[1] = last_b + first_b * 10 + last_a;
                } else if (b < 10) {
                    comb[0] = first_a + last_b * 10 + last_a;
                    comb[1] = last_a + first_a * 10 + last_b;
                } else {
                    comb[0] = first_a * 10 + last_b + first_b * 10 + last_a;
                    comb[1] = first_a * 10 + first_b + last_a * 10 + last_b;
                    comb[2] = last_b * 10 + last_a + first_b * 10 + first_a;
                    comb[3] = first_b * 10 + last_a + first_a * 10 + last_b;
                }
                ans=Collections.max(Arrays.asList(comb));
            }
            out.println(ans + "");
        }
        close.close();
    }

    static class Sc {
        private byte[] buf = new byte[1024];
        private int index;
        private InputStream in;
        private int total;

        public Sc() {
            in = System.in;
        }

        public int read() throws IOException {
            if (total < 0)
                throw new InputMismatchException();
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0)
                    return -1;
            }
            return buf[index++];
        }

        public int nextInt() throws IOException {
            int integer = 0;
            int n = read();
            while (isWhiteSpace(n))
                n = read();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = read();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = read();
                } else throw new InputMismatchException();
            }
            return neg * integer;
        }

        public double nextDouble() throws IOException {
            double doub = 0;
            int n = read();
            while (isWhiteSpace(n))
                n = read();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = read();
            }
            while (!isWhiteSpace(n) && n != '.') {
                if (n >= '0' && n <= '9') {
                    doub *= 10;
                    doub += n - '0';
                    n = read();
                } else throw new InputMismatchException();
            }
            if (n == '.') {
                n = read();
                double temp = 1;
                while (!isWhiteSpace(n)) {
                    if (n >= '0' && n <= '9') {
                        temp /= 10;
                        doub += (n - '0') * temp;
                        n = read();
                    } else throw new InputMismatchException();
                }
            }
            return doub * neg;
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