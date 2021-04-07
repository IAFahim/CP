package com.company;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class CountingRectangleTriangles {
    //    public class Main {
    public static int pow(int a, int b){//2^8
        // remeber to senc a%10 mod here
            if(b==0) return 1;
            int ret = pow(a,b/2);//half half removes the extra
            ret *= ret;//2^4 * 2^4
            if(b%2==1) ret *= a;
            return ret;//modified for last int
        }
    public static int countRectTriang(final Point[] points) {
        HashSet<Integer> setX = new HashSet<>();
        HashSet<Integer> setY = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            setX.add(points[i].x);
            setY.add(points[i].y);
        }
        return Math.min(setX.size(),setX.size());
    }

    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        out.println(countRectTriang(
                new Point[]{new Point(30, 26), new Point(36,  6), new Point(12, 27),
                        new Point( 9,  8), new Point( 9, 22), new Point( 6, 35),
                        new Point(26, 40), new Point(35, 18), new Point(27,  2),
                        new Point(19, 18), new Point( 2, 41), new Point(18,  3),
                        new Point( 4, 37), new Point(13, 25), new Point(21, 34),
                        new Point(27, 45), new Point(26, 12), new Point(23, 16),
                        new Point(28,  1), new Point( 0, 25), new Point(12, 25),
                        new Point(10, 41), new Point(24, 18), new Point(31, 38),
                        new Point(28, 17), new Point( 9, 23), new Point(29,  1),
                        new Point(21, 43), new Point(20, 46), new Point(50, 10)})+"");
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