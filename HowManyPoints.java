//package com.company;

import java.io.*;
import java.util.*;

public class HowManyPoints {
//public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till=sc.nextInt();
        ma m= new ma();
        for (int i = 1; i <= till; i++) {
            long x=sc.nextInt();
            long y=sc.nextInt();
            long X=sc.nextInt();
            long Y=sc.nextInt();
            out.println("Case "+i+": "+(m.gcd(Math.abs(x-X),Math.abs(y-Y))+1));
        }
        out.close();
    }

    public  static class ma {
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
