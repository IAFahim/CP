//package com.company;

import java.io.*;
import java.util.*;

public class kFactorization {
//    public class Main {
        public static ArrayList<Long> fragments (long n,long frag) {
            ArrayList<Long> divisors = new ArrayList<>();
            long i = 2;
            while (n != 1)
                if (n % i == 0) {
                    divisors.add(i);
                    n /= i;
                } else ++i;
            return divisors;
        }

    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int d=sc.nextInt(),c=sc.nextInt(),counterFill=1;
        ArrayList<Long> dis = fragments(d,2);
        if(dis.size()<c){
            out.println(-1);
        }else {
            for (int i = 0; i < c - 1; i++) {
                out.print(dis.get(i)+" ");
                counterFill*=dis.get(i);
            }
            out.println(d/counterFill);
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
