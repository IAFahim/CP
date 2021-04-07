//package com.company;

import java.io.*;
import java.time.Year;
import java.util.*;
public class TheCrystalMaze {
//    public class Main {
    static final int moveDirAllowedY[] = {0, 0, 1, -1};
    static final int moveDirAllowedX[] = {1, -1, 0, 0};//all dir look closely
    static int X = 0, Y = 0, count = 0, cost[][];//more like cost_at bayy
    static boolean grid_visited[][];
    static char grid[][];

    static void runBFS(int y, int x) {
//   if(maze[x][y]=='C') count++;
        if (grid[y][x] == 'C') {
            count++;
        }
//   visit[x][y]=true;
        grid_visited[y][x] = true;//remove current spot that you are on relpaced with wall #
        for (int i = 0; i < 4; i++) {//total 4 direction right up down left right with (x,y)
            int y_temp = moveDirAllowedY[i] + y;
            int x_temp = moveDirAllowedX[i] + x;
            //(x+0,y+1),(x+0,y-1),(x+1,y+0),(x-1,y+0)
            if (-1 < y_temp && -1 < x_temp && x_temp < X && y_temp < Y&& grid[y_temp][x_temp] != '#'  && !grid_visited[y_temp][x_temp] ) {
                runBFS(y_temp, x_temp);//just keep looking for cristal and replacing till you cant really move
                //like we all been doing all alone in real life
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        int till = sc.nextInt();
        for (int z = 0; z < till; z++) {
            out.println("Case " + (z + 1) + ":");
            Y = sc.nextInt();
            X = sc.nextInt();
            int n = sc.nextInt();
            grid = new char[Y][X];
            cost = new int[Y][X];
            for (int y = 0; y < Y; y++) {
                grid[y] = sc.nextString().toCharArray();
                Arrays.fill(cost[y], -1);
            }
            for (int i = 0; i < n; i++) {
                count = 0;
                grid_visited = new boolean[Y][X];
                int y = sc.nextInt() - 1, x = sc.nextInt() - 1;
                if (cost[y][x] == -1) {
                    runBFS(y, x);
                    out.print(count + "\n");
                    cost[y][x] = count;//bay get it ...  no one gets my jokes
                    for (int j = 0; j < Y; j++) {
                        for (int k = 0; k < X; k++) {
                            if (grid_visited[j][k]) {
                                cost[j][k] = count;
                            }
                        }
                    }
                } else {
                    out.println(cost[y][x] + "");
                }
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