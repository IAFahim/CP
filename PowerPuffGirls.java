//package com.company;

import java.io.*;
import java.util.*;

public class PowerPuffGirls {
//        public class Main {
    static final int moveDirAllowedX[] = {0, 0, 1, -1};
    static final int moveDirAllowedY[] = {1, -1, 0, 0};
    static char grid[][];
    static int pos[][];
    static boolean grid_visited[][];
    static int Y = 0, X = 0, count = 1;

    static void runBFS(int y, int x) {
        Queue<Integer> storeY = new LinkedList<>();
        Queue<Integer> storeX = new LinkedList<>();
        storeY.add(y);
        storeX.add(x);
        int visited[][] = new int[Y][X];
        visited[y][x] = 1;
        while (!storeX.isEmpty() && !storeY.isEmpty()) {
            int yy = storeY.poll(), xx = storeX.poll();
            for (int i = 0; i < 4; i++) {
                int y_temp = yy + moveDirAllowedY[i], x_temp = xx + moveDirAllowedX[i];
                if (-1 < y_temp && -1 < x_temp && y_temp < Y && x_temp < X && visited[y_temp][x_temp] == 0 && grid[y_temp][x_temp] != '#' && grid[y_temp][x_temp] != 'm') {
                    visited[y_temp][x_temp] = visited[yy][xx] + 1;
                    if (grid[y_temp][x_temp] == 'h') {
                        count = visited[y_temp][x_temp];
                        return;
                    }
                    storeY.add(y_temp);storeX.add(x_temp);
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        int till = sc.nextInt();
        for (int z = 0; z < till; z++) {
            Y = sc.nextInt();
            X = sc.nextInt();
            grid = new char[Y][X];
            pos = new int[3][2];
            int found = 0;
            for (int y = 0; y < Y; y++) {
                grid[y] = sc.nextString().toCharArray();
                for (int x = 0; found != 3 && x<X; x++) {
                    if (grid[y][x] == 'a') {
                        pos[0][0] = y;
                        pos[0][1] = x;
                        found++;
                    } else if (grid[y][x] == 'b') {
                        pos[1][0] = y;
                        pos[1][1] = x;
                        found++;
                    } else if (grid[y][x] == 'c') {
                        pos[2][0] = y;
                        pos[2][1] = x;
                        found++;
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < 3; i++) {
                count = 0;
                runBFS(pos[i][0], pos[i][1]);
                max = Math.max(max, count);
            }
            out.println("Case " + (z + 1) + ": " + (max-1));
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