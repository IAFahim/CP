//package com.company;

import java.io.*;
import java.util.*;

//public class Main {
public class BigMOd {

    static long bigMod(long a, long p, long m) { // returns (a^p) % m
        long res = 1 % m, x = a % m;
        while (p > 0) {
            if ((p & 1) > 0) res = (res * x) % m;
            x = (x * x) % m;
            p >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
    while (sc.br.ready()) {
        long a = sc.nextLong(), P = sc.nextLong(), m = sc.nextLong();
        out.println(bigMod(a, P, m));
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
