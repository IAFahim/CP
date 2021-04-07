//package com.company;

import java.io.*;
import java.util.*;

//public class Main {
public class Gcd2 {
    static long mod(String num, long a)
    {

        // Initialize result
        long res = 0;

        // One by one process all digits of 'num'
        for (long i = 0; i < num.length(); i++)
            res = (res * 10 + (long)num.charAt((int)i)
                    - '0') % a;

        return res;
    }
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start\
        int size=sc.nextInt();
        for (int i = 0; i < size; i++) {
        long a=sc.nextLong();
            long b=mod(sc.next(),a);
        out.println(b!=0?b:a);
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

