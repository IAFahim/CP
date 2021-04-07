package com.company;

import java.io.*;
import java.util.*;

public class SoNP {
    //    public class Main {
    class Graph<T> {

        // We use Hashmap to store the edges in the graph
        private Map<T, List<T> > map = new HashMap<>();

        // This function adds a new vertex to the graph
        public void addVertex(T s)
        {
            map.put(s, new LinkedList<T>());
        }

        // This function adds the edge
        // between source to destination
        public void addEdge(T source,
                            T destination,
                            boolean bidirectional)
        {

            if (!map.containsKey(source))
                addVertex(source);

            if (!map.containsKey(destination))
                addVertex(destination);

            map.get(source).add(destination);
            if (bidirectional == true) {
                map.get(destination).add(source);
            }
        }

        // This function gives the count of vertices
        public void getVertexCount()
        {
            System.out.println("The graph has "
                    + map.keySet().size()
                    + " vertex");
        }

        // This function gives the count of edges
        public void getEdgesCount(boolean bidirection)
        {
            int count = 0;
            for (T v : map.keySet()) {
                count += map.get(v).size();
            }
            if (bidirection == true) {
                count = count / 2;
            }
            System.out.println("The graph has "
                    + count
                    + " edges.");
        }

        // This function gives whether
        // a vertex is present or not.
        public void hasVertex(T s)
        {
            if (map.containsKey(s)) {
                System.out.println("The graph contains "
                        + s + " as a vertex.");
            }
            else {
                System.out.println("The graph does not contain "
                        + s + " as a vertex.");
            }
        }

        // This function gives whether an edge is present or not.
        public void hasEdge(T s, T d)
        {
            if (map.get(s).contains(d)) {
                System.out.println("The graph has an edge between "
                        + s + " and " + d + ".");
            }
            else {
                System.out.println("The graph has no edge between "
                        + s + " and " + d + ".");
            }
        }

        // Prints the adjancency list of each vertex.
        @Override
        public String toString()
        {
            StringBuilder builder = new StringBuilder();

            for (T v : map.keySet()) {
                builder.append(v.toString() + ": ");
                for (T w : map.get(v)) {
                    builder.append(w.toString() + " ");
                }
                builder.append("\n");
            }

            return (builder.toString());
        }
    }
    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));

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
}