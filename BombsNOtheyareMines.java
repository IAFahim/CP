//package com.company;

import java.io.*;
import java.util.*;

public class BombsNOtheyareMines {
//        public class Main {
    static final int moveDirAllowedX[] = {0, 0, 1, -1};
    static final int moveDirAllowedY[] = {1, -1, 0, 0};//all dir look closely
    static int grid[][];
    static boolean grid_visited[][];
    static int grid_distance[][];
    static int Y = 0, X = 0, count = 1;

    static int runBFS(int y_start, int x_start, int y_end, int x_end) {
        Queue<Integer> Ystore = new LinkedList<>();
        Queue<Integer> Xstore = new LinkedList<>();
        grid_distance = new int[Y][X];
        Ystore.offer(y_start);
        Xstore.offer(x_start);
        while (!Xstore.isEmpty()) {
            int y = Ystore.poll(), x = Xstore.poll();
            for (int i = 0; i < 4; i++) {
                int y_temp = y + moveDirAllowedY[i], x_temp = x + moveDirAllowedX[i];
                if (-1 < y_temp && -1 < x_temp && y_temp < Y && x_temp < X && !grid_visited[y_temp][x_temp]) {
                    grid_distance[y_temp][x_temp]=grid_distance[y][x]+1;
                    grid_visited[y_temp][x_temp]=true;
                    if (y_end == y_temp && x_end==x_temp){
                        return grid_distance[y_end][x_end];
                    }
                    Ystore.add(y_temp);
                    Xstore.add(x_temp);

                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            Y = sc.nextInt();
            X = sc.nextInt();
            if (Y == 0 && X == 0) break;
            grid = new int[Y][X];
            grid_visited = new boolean[Y][X];
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int y = sc.nextInt(), mines = sc.nextInt();
                for (int m = 0; m < mines; m++) {
                    int mine = sc.nextInt();
                    grid_visited[y][mine] = true;
                }
            }
            int y_start = sc.nextInt(), x_start = sc.nextInt(), y_end = sc.nextInt(), x_end = sc.nextInt();
            out.println(runBFS(y_start, x_start, y_end, x_end)+"");
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