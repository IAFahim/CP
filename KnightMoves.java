//package com.company;

import java.io.*;
import java.util.*;

public class KnightMoves {
//        public class Main {
    static int dx[] = {1, 1, -1, -1, 2, 2, -2, -2};
    static int dy[] = {2, -2, 2, -2, 1, -1, 1, -1};
    static char grid[][];
    static int pos[][];
    static int grid_visited[][];
    static int Y = 8, X = 8, endY = 0, endX = 0;

    static int run_dfs(int root_y, int root_x) {
        Queue<Integer> storeX = new LinkedList<>();
        Queue<Integer> storeY = new LinkedList<>();
        storeY.add(root_y);
        storeX.add(root_x);
        int y = root_y, x = root_x;
        while (!storeX.isEmpty()) {
            y = storeY.poll();
            x = storeX.poll();
            if (x == endX && y == endY) {
                return grid_visited[y][x];
            }
            for (int i = 0; i < dx.length; i++) {
                int y_temp = y + dy[i], x_temp = x + dx[i];
                if (-1 < y_temp && -1 < x_temp && y_temp < Y && x_temp < X && grid_visited[y_temp][x_temp] == 0) {
                    storeX.add(x_temp);
                    storeY.add(y_temp);
//                    out.println(Character.toString(y_temp + 'a') + " " + Character.toString(x_temp + '1'));
                    grid_visited[y_temp][x_temp] = grid_visited[y][x] + 1;
                }
            }


        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        while (sc.hasNext()) {
            grid_visited = new int[Y][X];
            String at = sc.next(), to = sc.next();
            int y = at.charAt(0) - 'a', x = at.charAt(1) - '1';
            endY = to.charAt(0) - 'a';
            endX = to.charAt(1) - '1';
            out.println("To get from " + at + " to " + to + " takes " + run_dfs(y, x) + " knight moves.");
        }
        close.close();
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

    static Scanner sc = new Scanner(System.in);
    static Print out = new Print();
    static BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
}