//package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class PrimeCuts {
//    public class Main {
    public static void main(String[] args) throws Exception{

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int max = 1001;
        boolean isPrime [] = new boolean[max + 1];
        Arrays.fill(isPrime , true);
        isPrime[0] = false;
        for (int i = 2 ; i * i <= max ; ++ i)
            if (isPrime[i])
                for (int j = i + i ; j <= max ; j += i)
                    isPrime[j] = false;

        while (sc.br.ready()) {
            int n = sc.nextInt() , c = sc.nextInt();
            ArrayList<Integer> primes = new ArrayList<>();
            for (int i = 0 ; i <= n ; ++ i)
                if (isPrime[i])
                    primes.add(i);
            out.print(n + " " + c + ":");
            if (primes.size() % 2 == 0) {
                for (int i = Math.max(0 , primes.size() / 2 - c) ; i < Math.min(primes.size() , primes.size() / 2 + c) ; i++)
                    out.print(" " + primes.get(i));
            }
            else {
                for (int i = Math.max(0 , primes.size() / 2 - c + 1) ; i < Math.min(primes.size() , primes.size() / 2 + c) ; i++)
                    out.print(" " + primes.get(i));
            }
            out.println("\n");

        }        out.close();
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
