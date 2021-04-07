//package com.company;

import java.io.*;
import java.util.*;

public class FindingLCM {
//public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int size = sc.nextInt();
        for (int i = 1; i <= size; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long L = sc.nextLong();
            ma m = new ma();
            long g = (b / m.gcd(a, b)) * a;
            if (L % g != 0)
                out.println("Case " + i + ": impossible");
            else {
                long c =(L / g);
                long d=m.gcd(c,g);
                while (d!=1){
                    c=c*d;
                    g=g/d;
                    d=m.gcd(c,g);
                }
                out.println("Case " + i + ": " + c);
            }

        }
        out.close();
    }

    public static class ma {
        public long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
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
