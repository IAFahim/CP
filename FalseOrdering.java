package com.company;

import org.w3c.dom.Node;

import java.io.*;
import java.sql.Array;
import java.sql.Connection;
import java.util.*;

public class FalseOrdering {
//        public class Main {
    static int n = 1001;

    public static class Data implements Comparable<Data> {
        int num;
        int count;

        public Data(int x, int y) {
            this.num=x;
            this.count=y;
        }

        @Override
        public int compareTo(Data data) {
            if(this.num==data.num)
            return data.count - this.count;
            else return this.num - data.num;

        }
    }
    static void mutiplefix() {
        for (int i = 0; i < n; i++) {
            int y=0;
            for (int j = 1; j*j <= i; j++) {
                if(i%j==0){
                y++;
                int temp = i/j;
                if(i%temp==0 &&(i/temp)!=temp)
                    y++;
                }
            }
            data[i]=new Data(y,i);
        }
    }

    static Data[] data=new Data[n];
    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        mutiplefix();
        for (int i = 0; i < n; i++) {
        debug(data[i].num);
        }
        Arrays.sort(data);
        int till = sc.nextInt();
        for (int z = 0; z < till; z++) {
            out.println("Case " + (z + 1) + ": " + data[sc.nextInt()].count);
        }
        close.close();
    }
    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj).replace("], ", "]\n"));
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