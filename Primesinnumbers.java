//package com.company;

import java.io.*;
import java.util.*;

public class Primesinnumbers {
    //    public class Main {
    static void setPrimeFactor(TreeMap<Long, Long> primeFactors, Long primeFactor) {
        Long multiplicity = primeFactors.containsKey(primeFactor) ? primeFactors.get(primeFactor) : 0;
        primeFactors.put(primeFactor, multiplicity + 1);
    }

    static TreeMap<Long, Long> primeFactorize(long n) {
        TreeMap<Long, Long> primeFactors = new TreeMap<>();
        Long multiplicity;
        long primeFactor = 0L;
        long i = 2L;
        while (i <= n / i) {
            if (n % i == 0) {
                primeFactor = i;
                setPrimeFactor(primeFactors, primeFactor);
                n /= i;
            } else {
                i++;
            }
        }
        if (primeFactor < n) primeFactor = n;
        setPrimeFactor(primeFactors, primeFactor);
        return primeFactors;
    }

    public static String factors(int n) {
        TreeMap<Long, Long> primeFactors = primeFactorize(n);
        StringBuilder str = new StringBuilder();
        for (long x : primeFactors.keySet()) {
            if (primeFactors.get(x) == 1) str.append("(" + x + ")");
            else str.append("(" + x + "**" + primeFactors.get(x) + ")");
        }
        return str.toString();
    }

    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        out.println(factors(sc.nextInt()));
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