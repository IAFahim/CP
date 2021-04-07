//package com.company;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Factorialdecomposition {
    //    public class Main {
    private static void setBigPrimeFactor(TreeMap<BigInteger, BigInteger> primeFactors, BigInteger primeFactor) {
        BigInteger multiplicity = primeFactors.containsKey(primeFactor) ? primeFactors.get(primeFactor) : BigInteger.ZERO;
        primeFactors.put(primeFactor, multiplicity.add(BigInteger.ONE));
    }

    public static TreeMap<BigInteger, BigInteger> primeBigFactorize(BigInteger n) {
        TreeMap<BigInteger, BigInteger> primeFactors = new TreeMap<>();
        BigInteger primeFactor = BigInteger.ZERO;
        BigInteger i = new BigInteger("2");

        while (i.compareTo(n.divide(i)) <= 0) {
            if (n.mod(i).longValue() == 0) {
                primeFactor = i;
                setBigPrimeFactor(primeFactors, primeFactor);
                n = n.divide(i);
            } else {
                i = i.add(BigInteger.ONE);
            }
        }

        if (primeFactor.compareTo(n) < 0) primeFactor = n;
        setBigPrimeFactor(primeFactors, primeFactor);

        return primeFactors;
    }
    public static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;

        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return result;
    }
    public static String decomp(int n) {
        TreeMap<BigInteger, BigInteger> primeFactors = primeBigFactorize(factorial(new BigInteger(n+"")));
        StringBuilder str = new StringBuilder();
        for (BigInteger x : primeFactors.keySet()) {
            if (primeFactors.get(x).equals(new BigInteger("1"))) str.append(x + " * ");
            else str.append( x + "^" + primeFactors.get(x) + " * ");
        }
        return str.substring(0,str.length()-3);
    }
    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        out.println(decomp(sc.nextInt()));
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