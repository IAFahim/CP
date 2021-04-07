package com.company;

import java.io.*;
import java.util.*;

public class PrefixSumandSquares {
//    public class Main {
//    static int n = 100000;
//        static int[] a = new int[n];
//
//        static void buildPrefixSum() { // O(n)
//            for (int i = 1; i < n; i++) {
//                a[i] += a[i - 1];
//            }
//            // a[i] ==> sum of a[(0 .... i)]
//            // original  = {5, 4, -7, 9, 10, 0, 1}
//            // prefixSum = {5, 9, 2, 11, 21, 21, 22}
//
//        }
//
//        static int getSum(int i, int j) { // O(1)
//            int sum = a[j];
//            if (i > 0) sum -= a[i - 1];
//            return sum;
//        }
//    static void squre(){
//        for (int i = 0; i < 22; i++) {
//            a[i*i]++;
//        }
//    }
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
       // squre();
       // buildPrefixSum();
        while (true){
            int a=sc.nextInt(),b=sc.nextInt();
            if(a==0&&b==0)break;
            out.println(((int)Math.floor(Math.sqrt(b))-(int)Math.ceil(Math.sqrt(a)))+1);
            //out.println(getSum(a,b));
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
