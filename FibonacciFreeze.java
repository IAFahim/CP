//package com.company;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.*;
import java.util.*;

public class FibonacciFreeze {
//        public class Main {

    static BigInteger fib(int n)
    {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
        for (int j=2 ; j<=n ; j++)
        {
            c =  a.add(b);
            a = b;
            b = c;
        }
        return (a);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        while (sc.hasNext()){
            int i=sc.nextInt();
            out.println("The Fibonacci number for "+i+" is "+fib(i+1));
        }
        close.close();
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