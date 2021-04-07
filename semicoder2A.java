//package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;


public class semicoder2A {
    //        public class Main {
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
            return x + " " + y;
        }

        @Override
        public int compareTo(Pair o) {
            if (x > o.x) {
                return 1;
            }
            if (x < o.x) {
                return -1;
            }
            return 0;
        }
    }

    public static void toSt(ArrayList<Pair> pair) throws IOException {
        Collections.sort(pair);
        for (int i = 0; i < pair.size(); i++) {
            out.print(pair.get(i).y + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        Pair pair[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            pair[i] = new Pair(sc.nextInt(), i);

        }
        int x = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pair[i].x;
        }
        if (sum == x) {
            for (int i = 0; i < n; i++) {
                out.println(pair[i].x + " ");
            }
        }
        ArrayList<Pair> store = new ArrayList<>();
        Arrays.sort(pair);
        sum = 0;
        int at = 1;
        ArrayList<Pair> st = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (x > pair[i].x) {
                sum += pair[i].x;
                store.add(pair[i]);
                if (sum == x) {
                    for (int j = 0; j < store.size(); j++) {
                        st.add(new Pair(store.get(j).y, store.get(j).x));
                    }
                    toSt(st);
                    close.close();
                    return;
                }
                int gap=1;
                if (sum-pair[gap].x == x) {
                    for (int j = 0; j < store.size(); j++) {
                        if(gap!=j)
                        st.add(new Pair(store.get(j).y, store.get(j).x));
                    }
                    toSt(st);
                    close.close();
                    return;
                }

            } else {
                sum = 0;
                store.clear();
                for (int j = at; j < n; j++) {
                    if (x > pair[j].x) {
                        sum += pair[j].x;
                        store.add(pair[j]);
                        if (sum == x) {
                            for (int k = 0; k < store.size(); k++) {
                                st.add(new Pair(store.get(k).y, store.get(k).x));
                            }
                            toSt(st);
                            close.close();
                            return;
                        }
                    }
                    if (sum > x) {
                        store.clear();
                        at++;
                        sum = 0;
                        continue;
                    }
                }
            }
        }


//        for (int i = 0; i < n; i++) {
//            if(pair[i].y==x){
//                out.println(pair[i].y+"");
//                break;
//            }
//            for (int j = 1; j < n; j++) {
//                if(pair[i].y+arr[j]==x){
//                    out.println(pair[i].y+" "+arr[j]);
//                    return;
//                }
//                for (int k = 2; k < n; k++) {
//                    if(pair[i].y+arr[j]+arr[k]==x){
//                        out.println(pair[i].y+" "+arr[j] +" "+arr[k]);
//                        return;
//                    }
//                    for (int l = 3; l < n; l++) {
//                        if(pair[i].y+arr[j]+arr[k]+arr[l]==x){
//                            out.println(pair[i].y+" "+arr[j] +" "+arr[k]+" "+arr[l]);
//                            return;
//                        }
//                        for (int m = 4; m < n; m++) {
//                            if(pair[i].y+arr[j]+arr[k]+arr[l]+arr[m]==x){
//                                out.println(pair[i].y+" "+arr[j] +" "+arr[k]+" "+arr[l]+" "+arr[m]);
//                                return;
//                            }
//                            for (int o = 5; o < n; o++) {
//                                if(pair[i].y+arr[j]+arr[k]+arr[l]+arr[m]+arr[o]==x){
//                                    out.println(pair[i].y+" "+arr[j] +" "+arr[k]+" "+arr[l]+" "+arr[m]+" "+arr[o]);
//                                    return;
//                                }
//                                for (int p = 6; p < n; p++) {
//                                    if(pair[i].y+arr[j]+arr[k]+arr[l]+arr[m]+arr[o]+arr[p]==x){
//                                        out.println(pair[i].y+" "+arr[j] +" "+arr[k]+" "+arr[l]+" "+arr[m]+" "+arr[o]+" "+arr[p]);
//                                        return;
//                                    }
//                                    for (int q = 7; q < n; q++) {
//                                        if(pair[i].y+arr[j]+arr[k]+arr[l]+arr[m]+arr[o]+arr[p]+arr[q]==x){
//                                            out.println(pair[i].y+" "+arr[j] +" "+arr[k]+" "+arr[l]+" "+arr[m]+" "+arr[o]+" "+arr[p]+" "+arr[q]);
//                                            return;
//                                        }
//                                        for (int r = 8; r < n; r++) {
//                                            if(pair[i].y+arr[j]+arr[k]+arr[l]+arr[m]+arr[o]+arr[p]+arr[q]+arr[r]==x){
//                                                out.println(pair[i].y+" "+arr[j] +" "+arr[k]+" "+arr[l]+" "+arr[m]+" "+arr[o]+" "+arr[p]+" "+arr[q]+" "+arr[r]);
//                                                return;
//                                            }
//                                            for (int s = 9; s < n; s++) {
//                                                if(pair[i].y+arr[j]+arr[k]+arr[l]+arr[m]+arr[o]+arr[p]+arr[q]+arr[r]+arr[s]==x){
//                                                    out.println(pair[i].y+" "+arr[j] +" "+arr[k]+" "+arr[l]+" "+arr[m]+" "+arr[o]+" "+arr[p]+" "+arr[q]+" "+arr[r]+arr[s]);
//                                                    return;
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
        out.println("-1");

        close.close();
    }






















    /* This is O(scary), but seems quick enough in practice. */

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj).replace("], ", "]\n"));
    }

    static void debugV2(Object... obj) {
        System.out.println(Arrays.deepToString(obj)
                .replace("],", "\n").replace(",", "\t")
                .replaceAll("[\\[\\]]", " "));
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
    // 11:28 AM Sun 03 2021 3/28/2021
}