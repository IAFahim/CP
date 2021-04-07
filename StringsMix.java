//package com.company;

import java.io.*;
import java.util.*;

public class StringsMix {
//        public class Main {
    public static String mix(String s1, String s2) {
        List<String> strings = new ArrayList<>();
        int[] i1 = new int[128];
        int[] i2 = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            i1[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            i2[s2.charAt(i)]++;
        }

        for (int i = 97; i < 123; i++) {
            if (i1[i] > 1 || i2[i] > 1)
                if (i1[i] < i2[i]) {
                    String str = "2:";
                    for (int j = 0; j < i2[i]; j++) {
                        str += Character.toString(i);
                    }
                    strings.add(str);
                } else if (i1[i] > i2[i]) {
                    String str = "1:";
                    for (int j = 0; j < i1[i]; j++) {
                        str += Character.toString(i);
                    }
                    strings.add(str);
                } else {
                    String str = "=:";
                    for (int j = 0; j < i2[i]; j++) {
                        str += Character.toString(i);
                    }
                    strings.add(str);
                }
        }
        return "99";
    }

    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        out.println(mix("my&friend&Paul has heavy hats! &", "my friend John has many many friends &"));
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