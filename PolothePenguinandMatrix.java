//package com.company;

import java.io.*;
import java.util.*;

public class PolothePenguinandMatrix {
//        public class Main {
    static int arr[];
    static int cal(int x){
        int i,res=0;
        for (int j = 0; j < arr.length; j++) {
            res+=Math.abs(arr[j]-x);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        int min=Integer.MAX_VALUE,n=sc.nextInt(),m=sc.nextInt(),dif=sc.nextInt(),len=n*m;
        arr=new int[len];
        for (int i = 0; i < len; i++) {
            arr[i]=sc.nextInt();
            min=Math.min(arr[i],min);
        } int i=0;
        for (; i < len; i++) {
            arr[i]-=min;
            if(arr[i]%dif>0)break;
            arr[i]/=dif;
        }
        if(i<len)
            out.println("-1");
        else {
            int l=0,r=10000/dif,m1=0,m2=0,s1=0,s2=0;
            while (l<=r){
                m1=l+(r-l)/3;
                m2=r-(r-l)/3;
                s1=cal(m1);
                s2=cal(m2);
                if(s1>s2){
                    l=m1+1;
                }else {
                    r=m2-1;
                }
            }
            out.println(s2+"");
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