//package com.company;

import java.io.*;
import java.util.*;

public class CompresstheList {
//        public class Main {
    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        int till = sc.nextInt();
        for (int z = 0; z < till; z++) {
            int n = sc.nextInt(), count = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            String answer="";
            for (int i = 0; i < n;) {
                if(i+2<n && arr[i]+2==arr[i+2]){
                    answer+=arr[i]+"...";
                    i+=3;
                    int k=i-1;
                    int temp=arr[k];
                    while (k+1<n && arr[k]+1==arr[k+1]){
                        temp=arr[++k];
                        i=k+1;
                    }
                    answer+=temp+",";
                }else {
                    answer+=arr[i++]+",";
                }
            }
            /*
            d=int(input())
            for n in range(d):
            x=int(input())
            arr=[int(new) for new in input().split()]
            brr=""
            i=0
            while(i<x):
            if(i+2<x and arr[i]+2==arr[i+2]):
            brr+=str(arr[i]);
            brr+='...'
            i+=3
            k=i-1
            l=int(arr[k])
            while(k+1<x and arr[k]+1==arr[k+1]):
            l=int(arr[k+1]);
            k+=1;
            i=k+1;
            brr+=str(l)+','
        else:
            brr+=str(arr[i])+','
            i+=1
            brr=brr[:-1]
            print(brr)*/

            out.println(answer.substring(0,answer.length()-1));
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