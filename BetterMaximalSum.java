package com.company;

import java.io.*;
import java.util.*;

public class BetterMaximalSum {
    //public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till=sc.nextInt();
        for (int i = 1; i <= till; i++) {
            int size=sc.nextInt();
            int[] arr=new int[size];
            for (int j = 0; j <size ; j++) {
                arr[j]+=sc.nextInt();
            }
            long max=0,sum=Long.MIN_VALUE;
            long[] longchart= new long[size];
            for (int j = 0; j < size; j++) {
                max=Math.max(arr[j],arr[j]+max);
                sum=Math.max(sum,max);
                longchart[j]=max;
            }
            max=0;
            long[] longerchart= new long[size];
            size--;
            for (int j = size; j >=0; j--) {
                max=Math.max(arr[j],arr[j]+max);
                longerchart[j]=max;
            }
            long total=sum;
            for (int j = 1; j < size; j++) {
                total=Math.max(total,longchart[j-1]+longerchart[j+1]);
            }
            out.println(total);
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
