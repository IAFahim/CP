//package com.company;

import java.io.*;
import java.sql.Connection;
import java.util.*;

import static java.lang.Math.*;

public class Camouflage {
//        public class Main {
    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};
    static char grid[][];
    static int Y = 0, X = 0, count = 0, dot = 0;


    static boolean run_dfs(int y, int x) {
        count = 0;
        for (int i = 0; i < dx.length; i++) {
            int y_temp = y + dy[i], x_temp = x + dx[i];
            if (-1 < y_temp && -1 < x_temp && y_temp < Y && x_temp < X && grid[y_temp][x_temp] == '#') {
                count++;
            }
        }
        return count > 2;
    }

    public static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair clone() {
            return new Pair(x, y);
        }

        public String toString() {
            return y + " " + x;
        }

        public int compareTo(Pair o) {
            if (y > o.y) {
                return 1;
            }
            if (y < o.y) {
                return -1;
            }
            if (x > o.x) {
                return 1;
            }
            if (x < o.x) {
                return -1;
            }
            return 0;
        }
    }


    public static void main(String[] args) throws IOException {
        Y = sc.nextInt();
        X = sc.nextInt();
        dot = sc.nextInt();
        grid = new char[Y][X];
        for (int y = 0; y < Y; y++) {
            grid[y] = sc.readLine().toCharArray();
        }
        int dot_previous=0;
        while (0 < dot && dot_previous != dot) {
            dot_previous=dot;
            ArrayList<Pair> found_3 = new ArrayList<>();
            ArrayList<Pair> found_4 = new ArrayList<>();
            boolean goOn = true;
            for (int y = 0; y < Y; y++) {
                for (int x = 0; x < X; x++) {
                    if (grid[y][x] == '.' && run_dfs(y, x)) {
                        if (count == 3)
                            found_3.add(new Pair(x, y));
                        else
                            found_4.add(new Pair(x, y));
                    }
                }
            }
            Collections.sort(found_4);
//            debug(found_4);
            for (int i = 0; i < found_4.size() && dot > 0; i++) {
                Pair current = found_4.get(i);
                grid[current.y][current.x] = '#';
                dot--;
            }
            Collections.sort(found_3);
//            debug(found_3);
            for (int i = 0; i < found_3.size() && dot > 0; i++) {
                Pair current = found_3.get(i);
                grid[current.y][current.x] = '#';
                dot--;
            }
//            debug(grid);
        }
        for (int i = 0; i < Y; i++) {
            out.println(String.valueOf(grid[i]));
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