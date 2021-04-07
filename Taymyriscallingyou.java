//package com.company;

import java.io.*;
import java.util.*;
public class Taymyriscallingyou {
//    public class Main {
    public static long gcd(long a,long b){
            return a == 0 ? b : gcd(b % a, a);
        }

        public static long lcm(long  a, long b) {
            return a / gcd(a, b) * b;
        }
        public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int callpermin=sc.nextInt(),timeItTakesToCome=sc.nextInt(),totalMin=sc.nextInt();
        out.println(totalMin/lcm(callpermin,timeItTakesToCome));
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
