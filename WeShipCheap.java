//package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class WeShipCheap {
//            public class Main {
    static int SIZE = 705;
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

    static boolean visited[];
    static int distance[];
    static int genarated_Path[];

    static void runBFS(int from, int to) throws IOException {
        Queue<Integer> store = new LinkedList<>();
        store.add(from);
        genarated_Path[from] = from;
        visited[from] = true;
        while (!store.isEmpty()) {
            int root = store.poll();
            for (int i : adj.get(root)) {
                if (distance[i] > distance[root]+1) {
                    distance[i] = distance[root] + 1;
                    genarated_Path[i] = root;
                    if (!visited[i]) {
                        visited[i] = true;
                        store.add(i);
                    }
                }
            }
        }
        if (distance[to] == Integer.MAX_VALUE) {
            out.println("No route");
        } else {
            print_path(to, from);
        }
    }

    static void print_path(int to, int from) throws IOException {
        if (to == from)
            return;
        print_path(genarated_Path[to], from);
        out.println((char) (genarated_Path[to] / 26 + 'A') + "" + (char) (genarated_Path[to] % 26 + 'A') + " " + (char) (to / 26 + 'A') + (char) (to % 26 + 'A'));
    }

    static Print out = new Print();
    static BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean odd_sapce = false;
        while (sc.hasNext()) {
            int node = sc.nextInt();
            clearGraph();
            for (int i = 0; i < node; i++) {
                String first_st = sc.next(), second_st = sc.next();
                int first = 26 * (first_st.charAt(0) - 'A') + (first_st.charAt(1) - 65),
                        second = 26 * (second_st.charAt(0) - 'A') + (second_st.charAt(1) - 'A');
                addEdge(first, second);
            }
            String first_st = sc.next(), second_st = sc.next();
            int from = 26 * (first_st.charAt(0) - 'A') + (first_st.charAt(1) - 65),
                    to = 26 * (second_st.charAt(0) - 'A') + (second_st.charAt(1) - 'A');
            visited = new boolean[SIZE];
            distance = new int[SIZE];
            genarated_Path = new int[SIZE];
            Arrays.fill(distance, Integer.MAX_VALUE);
            if (odd_sapce) {
                out.println("");
            }
            runBFS(from, to);
            odd_sapce = true;
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
}