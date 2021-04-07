package com.company;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Tprimes {
//public class Main {
    static int n=100000;
    static boolean prime[] = new boolean[n+1];
    public static void sieveOfEratosthenes() {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        for (int i = 0; i < n; i++)
            prime[i] = true;


        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
    }
    static boolean isThreeDisctFactors(long n)
    {
        // Find square root of number
        int sq = (int) Math.sqrt(n);

        // Check whether number is perfect
        // square or not
        if (1L * sq * sq != n)
            return false;

        // If number is perfect square, check
        // whether square root is prime or
        // not
        return prime[sq] ? true : false;
    }
    public static void main(String[] args) {
    out = new PrintWriter(new BufferedOutputStream(System.out));
    MyScanner sc = new MyScanner();//start
    int till=sc.nextInt();
    for (int i = 1; i <= till; i++) {
        out.println(isThreeDisctFactors(sc.nextInt())?"YES":"NO");
    }
    out.close();
}


//-----------PrintWriter for faster output---------------------------------
public static PrintWriter out;

//-----------MyScanner class for faster input----------
public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}
//--------------------------------------------------------

}
