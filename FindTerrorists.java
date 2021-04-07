package com.company;

import java.io.*;
import java.util.*;

public class FindTerrorists {
    //    public class Main {
    static int n = 100000;
    static boolean prime[] = new boolean[n + 1];

    public static void sieveOfEratosthenes() {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        for (int i = 0; i < n; i++)
            prime[i] = true;
        prime[1]=false;
        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        fix_sieve();
    }

    static boolean prime2[] = new boolean[n + 1];
    static void fix_sieve() {
        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                int j=i*i;
                if(n>=j)prime2[j] = true;
                else return;
            }

        }
    }


    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        sieveOfEratosthenes();
        int till = sc.nextInt();
        for (int k = 1; k <= till; k++) {
            int a = sc.nextInt(), b = sc.nextInt();
            boolean found = false;
            boolean first_num = true;
            for (int i = a; i <= b; i++) {
                if (prime[i]||prime2[i]) {
                    out.print(first_num ? i : " " + i);
                    first_num = false;
                    found = true;
                }
            }
            out.println(found ? "" : -1);
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
