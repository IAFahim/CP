package com.company;

import java.io.*;
import java.util.*;

public class Simplenumbersequence {
    //    public class Main {
    public static int missing(String s) {
        int missing = -1, size = 0, i = 0;
        long previous=0,current=0;
        while ((2 * i) + 2 <= s.length() &&(2 * i) + 2<20) {
            current=Long.parseLong(s.substring(1 + i, (2 * i) + 2));
            previous=Long.parseLong(s.substring(0, 1 + i));
            if(current<previous){
                size=++i+1;
                break;
            }else if (current-previous==1) {
                size = ++i;
                 continue;
            }
            i++;
        }
        int found = 0;
        int[] arr = new int[s.length() / size+1];
        for (int j = 0, l = 0; j + size <= s.length(); j += size, l++) {
            arr[l] = Integer.parseInt(s.substring(j, j + size));
            if (0 < l && arr[l] <= arr[l - 1]) {
                arr[l] = Integer.parseInt(s.substring(j, ++j + size));
            }
            if (0 < l && arr[l] > arr[l - 1] + 1) {
                missing = arr[l - 1] + 1;
                found++;
            }
            if (0 < l && arr[l] > arr[l - 1] + 2) {
                return -1;
            }
            if (1 < found)
                return -1;
        }
        return missing;
    }

    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        out.println(missing(sc.nextString()) + "");
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