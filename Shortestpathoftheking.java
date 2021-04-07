//package com.company;

import java.io.*;
import java.util.*;

public class Shortestpathoftheking {
//        public class Main {

    static int dx[] = {0, 1, -1, 0, 1, 1, -1, -1};
    static int dy[] = {1, 0, 0, -1, 1, -1, 1, -1};
    static int grid[][];
    static int Y = 8, X = 8, count = 1;
    static int grid_distance[][] = new int[Y][X];

    //int till = sc.nextInt();
    //}

    static void run_Bfs(int y, int x) {
        Queue<Integer> storeY = new LinkedList<>();
        Queue<Integer> storeX = new LinkedList<>();
        storeX.add(x);
        storeY.add(y);
        while (!storeY.isEmpty()) {
            int yy = storeY.poll();
            int xx = storeX.poll();
            grid_visited[yy][xx] = true;
            for (int i = 0; i < dx.length; i++) {
                int y_temp = yy + dy[i], x_temp = xx + dx[i];
                if (-1 < y_temp && -1 < x_temp && y_temp < Y && x_temp < X && !grid_visited[y_temp][x_temp]) {
                    grid_visited[y_temp][x_temp] = true;
                    grid_distance[y_temp][x_temp] = grid_distance[yy][xx] + 1;
                    storeX.add(x_temp);
                    storeY.add(y_temp);
                }

            }
        }

    }

    static boolean grid_visited[][] = new boolean[Y][X];

    public static void main(String[] args) throws IOException {

        String from = sc.nextString(), to = sc.nextString();
        int y = from.charAt(0) - 'a', x = from.charAt(1) - '1';
        int yy = to.charAt(0) - 'a', xx = to.charAt(1) - '1';
        int yyy = yy - y, xxx = xx - x;
//        out.println(ans+"");
        run_Bfs(y, x);
        out.println((grid_distance[yy][xx]) + "");
        while (yyy != 0 || xxx != 0) {
            if (yyy < 0) {
                out.print("L");
                yyy++;
            }
            if (yyy > 0) {
                yyy--;
                out.print("R");
            }
            if (xxx > 0) {
                out.print("U");
                xxx--;
            }
            if (xxx < 0) {
                xxx++;
                out.print("D");
            }
            out.println("");
        }
//        debug(grid_distance);
        close.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj).replace("], ", "]\n"));
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