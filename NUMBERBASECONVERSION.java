//package com.company;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class NUMBERBASECONVERSION {
//        public class Main {
    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        char c;
        int testCase, i, w;
        BigInteger ba1, ba2, t, sum;
        testCase = sc.nextInt();
        while ((testCase--)!= 0) {
            ba1 = new BigInteger(sc.nextString());ba2 =  new BigInteger(sc.nextString());
            String st = sc.nextString();
            t = new BigInteger ("1");
            sum = new BigInteger ("0");
            for (i = st.length ()-1; i>= 0; i--) {
                c = st.charAt (i);
                if (c>= '0' && c <= '9') w = c-'0';
                else if (c>= 'A' && c <= 'Z') w = c-'A' + 10;
                else w = c-'a' + 36;
                sum = sum.add (BigInteger.valueOf(w) .multiply(t));
                t = t.multiply (ba1);
            }
            BigInteger zero = BigInteger.valueOf(0);
            int top = 0, stack [] = new int [2000];
            while (sum.compareTo (zero)!= 0) {
                stack [++ top] = sum.mod (ba2) .intValue ();
                sum = sum.divide (ba2);
            }
            out.print(ba1 + " " + st + "\n" + ba2 +" ");
            if (top == 0) out.print("0");;
            while (top!=0) {
                w = stack [top--];
                if (w <10) c = (char) ('0' + w);
                else if (w <36) c = (char) (w-10 + 'A');
                else c = (char) (w-36 + 'a');
                out.print(c+"");;
            }
            out.println("\n");
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