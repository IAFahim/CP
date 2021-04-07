//package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class SallusNightmare {
//        public class Main {
    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};
    static char grid[][];
    static int pos[][];
    static int peek[][];
    static int time[][];
    static boolean grid_visited[][];
    static int Y = 0, X = 0, count = 1;
    static Queue<Integer> xfire, yfire;

    static int run_BFS(int y, int x) {
        time[y][x] = 1;
        yfire = new LinkedList<>();
        xfire = new LinkedList<>();
        yfire.add(y);
        xfire.add(x);
        grid_visited[y][x]=true;
        while (!yfire.isEmpty()) {
            int yy = yfire.poll(), xx = xfire.poll();
            for (int i = 0; i < dx.length; i++) {
                int y_temp = yy + dy[i], x_temp = xx + dx[i];
                if (-1 < y_temp && -1 < x_temp && y_temp < Y && x_temp < X && !grid_visited[y_temp][x_temp]&&
                        (peek[y_temp][x_temp]==0 || time[yy][xx]+1 < peek[y_temp][x_temp]) && (grid[y_temp][x_temp]=='.'|| grid[y_temp][x_temp]=='X')) {
                    if (grid[y_temp][x_temp]=='X') {
                        return time[yy][xx] + 1;
                    }
                    yfire.add(y_temp);
                    xfire.add(x_temp);
                    time[y_temp][x_temp] = time[yy][xx] + 1;
                    grid_visited[y_temp][x_temp]=true;
                }
            }
        }
        return -1;
    }

    static void rise_spred_BFS() {
        while (!xfire.isEmpty()) {
            int y = yfire.poll();
            int x = xfire.poll();
            for (int i = 0; i < 4; i++) {
                int y_temp = y + dy[i], x_temp = x + dx[i];
                if (-1 < y_temp && -1 < x_temp && y_temp < Y && x_temp < X && grid[y_temp][x_temp] == '.' && peek[y_temp][x_temp] < 1) {
                    yfire.add(y_temp);
                    xfire.add(x_temp);
                    peek[y_temp][x_temp] = peek[y][x] + 1;
                }
            }
        }
    }
    static boolean found;
    public static void main(String[] args) throws IOException {
        int till = sc.nextInt();
        for (int z = 0; z < till; z++) {
            Y = sc.nextInt();
            X = sc.nextInt();
            grid = new char[Y][X];
            peek=new int[Y][X];
            int gy = 0, gx = 0, fy = 0, fx = 0;
            found=false;
            yfire = new LinkedList<>();
            xfire = new LinkedList<>();
            for (int y = 0; y < Y; y++) {
                grid[y] = sc.nextString().toCharArray();
                for (int x = 0; x < X; x++) {
                    if (grid[y][x] == '*') {
                        yfire.add(y);
                        xfire.add(x);
                        peek[y][x] = 1;
                    } else if (!found && grid[y][x] == 'S') {
                        gy = y;
                        gx = x;
                        found = true;
                    }
                }
            }
            rise_spred_BFS();
            debug(peek);
            grid_visited=new boolean[Y][X];
            time = new int[Y][X];
            int answer= run_BFS(gy, gx);
            debug(grid_visited);
            out.println((answer==-1 ? "no" : "yes"));
        }

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