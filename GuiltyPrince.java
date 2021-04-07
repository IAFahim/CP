//package com.company;

import java.io.*;
import java.util.*;

public class GuiltyPrince {
//        public class Main {
    static int count = 1;
    static final int moveDirAllowedX[] = {0, 0, 1, -1};
    static final int moveDirAllowedY[] = {1, -1, 0, 0};//all dir look closely
    static char grid[][];
    static int Y = 0, X = 0;

    static void runBFS(int y, int x) {
        grid[y][x] = '#';//remove current spot that you are on relpaced with water #
        for (int i = 0; i < 4; i++) {//total 4 direction right up down left right with (x,y)
            int y_temp = moveDirAllowedY[i] + y;
            int x_temp = moveDirAllowedX[i] + x;
            //(x+0,y+1),(x+0,y-1),(x+1,y+0),(x-1,y+0)
            if (-1 < y_temp && -1 < x_temp && x_temp < X && y_temp < Y && grid[y_temp][x_temp] == '.'){
                runBFS(y_temp,x_temp);//just keep looking for land and replacing till you cant really move
                //like we all been doing all alone in real life
                count++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        int till = sc.nextInt();
        for (int z = 0; z < till; z++) {
            X = sc.nextInt();
            Y = sc.nextInt();
            count=1;
            grid = new char[Y][X];
            for (int y = 0; y < Y; y++) {
                grid[y] = sc.nextString().toCharArray();
            }
            for (int y = 0; y < Y; y++) {
                for (int x = 0; x < X; x++) {
                    if (grid[y][x] == '@'){
                        runBFS(y, x);
                        break;
                    }
                }
            }
            out.println("Case "+(z+1)+": "+count);
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