package com.company;

import java.io.*;
import java.util.*;

public class HittheLightSwitches {
//        public class Main {
    static int SIZE = 1000;
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
//    adj.get(lastVertex).add(firstVertex);
    }

    static Stack<Integer> store;

    static void runDFS(int y) {
        visited[y] = true;
        for (int i : adj.get(y)) {
            if (!visited[i])
                runDFS(i);
        }
        store.add(y);
    }

    static void runBFS(int y) {
        Queue<Integer> tempStore = new LinkedList<>();
        tempStore.add(y);
        while (!tempStore.isEmpty()) {
            int root = tempStore.poll();
            for (int i : adj.get(root)) {
                if (!visited[i]) {
                    visited[i]=true;
                    tempStore.add(i);
                }
            }
        }
    }

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int till = sc.nextInt();
        for (int z = 0; z < till; z++) {
            SIZE = sc.nextInt();
            int e = sc.nextInt();
            clearGraph();
            for (int i = 0; i < e; i++) {
                int first = sc.nextInt() - 1, second = sc.nextInt() - 1;
                    addEdge(first, second);
            }
            visited = new boolean[SIZE];
            store=new Stack<>();
            for (int i = 0; i < SIZE; i++) {
                if(!visited[i])
                runDFS(i);
            }
            visited = new boolean[SIZE];
            int time_you_need_run_BFS_to_get_to_all_edges = 0;
            while (!store.isEmpty()){
                int x=store.pop();
                if (!visited[x]) {
                    visited[x]=true;
                    runBFS(x);
                    time_you_need_run_BFS_to_get_to_all_edges++;
                }
            }


            out.println("Case " + (z + 1) + ": " + time_you_need_run_BFS_to_get_to_all_edges);
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