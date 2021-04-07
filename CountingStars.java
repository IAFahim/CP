//package com.company;

import java.io.*;
import java.util.*;

public class CountingStars {
//        public class Main {
    static int movedirCircle_X[]={-1,0,1,-1,1,-1,0,1};
    static int movedirCircle_Y[]={-1,-1,-1,0,0,1,1,1};
    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int Y = sc.nextInt(),X=sc.nextInt();if (X == 0 && Y==0) break;
            char grid[][]=new char[Y][X];
            for (int y = 0; y < Y; y++) {
                grid[y]=sc.nextString().toCharArray();
            }
            int count=0;
            for (int y = 0; y < Y; y++) {
                for (int x = 0; x < X; x++) {
                    if(grid[y][x]=='*'){
                        boolean carve=false;
                        for (int i = 0; i < 8; i++) {
                            int y_temp=movedirCircle_Y[i]+y;
                            int x_temp=movedirCircle_X[i]+x;
                            if(-1<y_temp && -1<x_temp && y_temp<Y && x_temp<X && grid[y_temp][x_temp]=='*'){
                                carve=true;
                                break;
                            }
                        }
                        if(!carve){
                            count++;
                        }
                    }
                }
            }
            out.println(count+"");
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