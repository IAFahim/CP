//package com.company;

import java.io.*;
import java.util.*;

public class StickerCollectorRobot {
//        public class Main {
    static char grid[][], instruction[];
    static int Y = 1, X = 1, count = 0, n = 1, face = 0, y = 0, x = 0;

    static void run()throws IOException {
        for (int at = 0; at < n; at++) {
            if (instruction[at] == 'D') {
                face = (face + 1) % 4;
            } else if (instruction[at] == 'E') {
                face = (face == 0) ? 3 : face-1;
            } else {
                int x_temp = x, y_temp = y;
                if (face == 0) y_temp--;
                else if (face == 1) x_temp++;
                else if (face == 2) y_temp++;
                else x_temp--;
//                out.println(at+" "+y_temp+" "+x_temp);
                if (-1 < y_temp && -1 < x_temp && y_temp < Y && x_temp < X && grid[y_temp][x_temp] != '#') {
                    grid[y][x] = '.';
                    if (grid[y_temp][x_temp] == '*') count++;
                    y=y_temp;
                    x=x_temp;
//                out.print(grid[y_temp][x_temp]+" ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            Y = sc.nextInt();
            X = sc.nextInt();
            n = sc.nextInt();
            if (X == 0 || Y == 0 || n == 0) break;
            grid = new char[Y][X];
            boolean found = false;
            int yy = 0;
            for (y = 0; y < Y; y++) {
                grid[y] = sc.nextString().toCharArray();
                if (!found)
                    for (x = 0; x < X; x++) {
                        if (grid[y][x] == 'N' || grid[y][x] == 'S' || grid[y][x] == 'L' || grid[y][x] == 'O') {
                            yy = y;
                            found = true;
                            break;
                        }
                    }
            }
            y = yy;
            if (grid[y][x] == 'N') face = 0;
            else if (grid[y][x] == 'L') face = 1;
            else if (grid[y][x] == 'S') face = 2;
            else if (grid[y][x] == 'O') face = 3;
            instruction = sc.nextString().toCharArray();
            count = 0;
            run();
            out.println(count + "");

        }

        close.close();
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
}