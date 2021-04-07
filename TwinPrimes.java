//package com.company;

import java.io.*;
import java.util.*;

public class TwinPrimes {
//public class Main {
    static int[][] twins = new int[1000001][2];

    public static class siv {
        void sieveOfEratosthenes(int n) {
            // Create a boolean array "prime[0..n]" and initialize
            // all entries it as true. A value in prime[i] will
            // finally be false if i is Not a prime, else true.
            boolean prime[] = new boolean[n + 1];
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

            // Print all prime numbers
            for (int i = 5,j=1; i <= n; i++) {
                    if(prime[i-2]&&prime[i]){
                    twins[j][0]=i-2;
                    twins[j][1]=i;
                        j++;
                    }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        siv s=new siv();
        s.sieveOfEratosthenes(20000000);
//        s.sieveOfEratosthenes(100);
        while (sc.br.ready()) {
//        while (true) {
            int n=sc.nextInt();
            out.println("("+twins[n][0]+", "+twins[n][1]+")");
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

