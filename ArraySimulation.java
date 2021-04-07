//package com.company;

import java.io.*;
import java.util.*;

public class ArraySimulation {
    //    public class Main {
    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        int till = sc.nextInt();
        for (int z = 0; z < till; z++) {
            int c = sc.nextInt();
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < c; i++) {
                arr.add(sc.nextInt());
            }
            for (int i = 0; i < n; i++) {
                String str = sc.nextString();
                if (str.equals("P")) {
                    int a = sc.nextInt(), b = sc.nextInt(), x = arr.get(a);
                    arr.set(a,arr.get(b));
                    arr.set(b, x);
                } else if (str.equals("S")) {
                    int x = sc.nextInt();
                    for (int j = 0; j < arr.size(); j++) {
                        arr.set(j,arr.get(j) + x);
                    }
                } else if (str.equals("M")) {
                    int x = sc.nextInt();
                    for (int j = 0; j < arr.size(); j++) {
                        arr.set(j,arr.get(j) * x);
                    }
                } else if (str.equals("D")) {
                    int x = sc.nextInt();
                    for (int j = 0; j < arr.size(); j++) {
                        arr.set(j,arr.get(j) / x);
                    }
                } else {
                    Collections.reverse(arr);
                }
            }
            out.println("Case "+(z+1)+":");
            out.print(""+arr.get(0));
            for(int i=1;i<arr.size();i++){
                out.print(" "+arr.get(i));
            }
            out.println("");
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