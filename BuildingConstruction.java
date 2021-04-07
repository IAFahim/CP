//package com.company;

import java.io.*;
import java.util.*;

public class BuildingConstruction {
//        public class Main {
    public static long cost(int[] heights,int[] costs, int height)
    {
        long sum=0;
        for(int i=0;i<heights.length;i++)
        {
            sum+=Math.abs(heights[i]-height)*costs[i];

        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        int till=sc.nextInt();
        for (int z = 0; z < till; z++) {
            int n=sc.nextInt(),max=-1;
            int[] heights=new int[n];
            for (int i = 0; i < n; i++) {
                heights[i]=sc.nextInt();
                max=Math.max(max,heights[i]);
            }
            int[] costs=new int[n];
            for (int i = 0; i < n; i++) {
                costs[i]=sc.nextInt();
            }
            int l=0,r=max;
            long answer=Long.MAX_VALUE;
            while (l<=r){
                int mid=l+(r-l)/2;
                long mid1=cost(heights,costs,mid);
                long midx=Long.MAX_VALUE;
                if(mid+1<=max)
                    midx=cost(heights,costs,mid+1);
                answer=Math.min(answer,mid1);
                if(midx<mid1){
                    l=mid+1;
                }
                else {
                    r=mid-1;
                }

            }
            out.println(answer+"");
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