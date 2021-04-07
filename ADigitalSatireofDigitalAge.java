package com.company;

import java.io.*;
import java.util.*;

public class ADigitalSatireofDigitalAge {
    //    public class Main {
    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder right = new StringBuilder(
                ".../\\...||........\n" +
                        "../..\\..||........\n" +
                        "./....\\.||.../\\...\n" +
                        "/......\\||../..\\..\n" +
                        "\\______/||./....\\.\n" +
                        "........||/......\\\n" +
                        "........||\\______/");
        StringBuilder equal = new StringBuilder(
                "........||........\n" +
                        ".../\\...||.../\\...\n" +
                        "../..\\..||../..\\..\n" +
                        "./....\\.||./....\\.\n" +
                        "/......\\||/......\\\n" +
                        "\\______/||\\______/\n" +
                        "........||........");

        StringBuilder left = new StringBuilder(
                "........||.../\\...\n" +
                        "........||../..\\..\n" +
                        ".../\\...||./....\\.\n" +
                        "../..\\..||/......\\\n" +
                        "./....\\.||\\______/\n" +
                        "/......\\||........\n" +
                        "\\______/||........");

        int till = sc.nextInt();
        for (int z = 0,x=0; z < till; z++) {
            out.println("Case " + (z + 1) + ":");
            String strR = "", strL = "";
            sc.nextString();
            sc.nextString();
            sc.nextString();
            boolean found = false, rightUP = false, leftUP = false;
            for (int i = 0; i < 3; i++) {
                StringBuilder str = new StringBuilder(sc.nextString());
                for (int j = 1; j < 7; j++) {
                    if ('A' <= str.charAt(j) && str.charAt(j) <= 'Z') {
                        strL += str.charAt(j);
                        x-=str.charAt(i);
                    } else {
                        if (!found) {
                            rightUP = true;
                            found = true;
                        }
                        break;
                    }
                }
                for (int j = 11; j < 18; j++) {
                    if ('A' <= str.charAt(j) && str.charAt(j) <= 'Z') {
                        strR += str.charAt(j);
                        x+=str.charAt(i);
                    } else {
                        if (!found) {
                            leftUP = true;
                            found = true;
                        }
                        break;
                    }
                }
            }
            sc.nextString();
            sc.nextString();
            if (x == 0) {
                if (!rightUP && !leftUP) {
                    out.println("The figure is correct.");
                    continue;
                }
                StringBuilder ans = equal;
                ans.replace(87, 87 + strL.length(), strL);
                ans.replace(77, 77 + strR.length(), strR);
                out.println(equal.toString());
            } else if (rightUP) {
                if (x<0) {
                    out.println("The figure is correct.");
                    continue;
                }
                StringBuilder ans = left;
                ans.replace(68, 68 + strR.length(), strR);
                ans.replace(96, 96 + strL.length(), strL);
                out.println(left.toString());
            } else if (leftUP) {
                if (x>0) {
                    out.println("The figure is correct.");
                    continue;
                }
                StringBuilder ans = right;
                ans.replace(58, 58 + strL.length(), strL);
                ans.replace(106, 106 + strR.length(), strR);
                out.println(right.toString());
            }
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