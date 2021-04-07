//package com.company;

import java.awt.*;
import java.io.*;
import java.sql.Array;
import java.util.*;

public class BacktoUnderworld {
//public class Main {
    static int SIZE = 20005, vamphire_count = 0, other_count = 0, high = 0;
    static ArrayList<ArrayList<Integer>> adj;

    static void clearGraph() {
        adj = new ArrayList<ArrayList<Integer>>(SIZE);
        for (int i = 0; i < SIZE; i++) adj.add(new ArrayList<Integer>());
    }

    static void printAdjacency() {
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).isEmpty()) continue;
            System.out.print(i + ": ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    static void addEdge(int firstVertex, int lastVertex) {
        adj.get(firstVertex).add(lastVertex);
        adj.get(lastVertex).add(firstVertex);
    }

    enum Color {
        NONE, VAMPIRE, OTHER;
    }

    static int runBFS(int root) {
        vamphire_count = 1;
        other_count = 0;
        visited[root] = Color.VAMPIRE;
        Queue<Integer> store = new LinkedList<>();
        store.add(root);
        while (!store.isEmpty()) {
            int x = store.poll();
            Color current_color = visited[x];
            for (int j : adj.get(x)) {
                if (visited[j] == Color.NONE) {
                    store.add(j);
                    if (current_color == Color.VAMPIRE) {
                        visited[j] = Color.OTHER;
                        other_count++;
                    } else {
                        visited[j] = Color.VAMPIRE;
                        vamphire_count++;
                    }
                }
            }
        }
        if (vamphire_count > other_count) {
            return vamphire_count;
        }
        return other_count;
    }

    static Color visited[];

    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        int till = sc.nextInt();
        for (int z = 0; z < till; z++) {
            int n = sc.nextInt();
            clearGraph();
            for (int i = 0; i < n; i++) {
                int firstVertex = sc.nextInt(), secondVertex = sc.nextInt();
                addEdge(firstVertex, secondVertex);
            }
            visited = new Color[SIZE];
            Arrays.fill(visited, Color.NONE);
            high = 0;
            for (int i = 0; i < SIZE; i++) {
                if (0 < adj.get(i).size() && visited[i] == Color.NONE)
                    high += runBFS(i);
            }
            out.println("Case " + (z + 1) + ": " + high);
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