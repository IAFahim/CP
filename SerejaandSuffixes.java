//package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class SerejaandSuffixes {
//    public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        Set<Integer> set=new HashSet<Integer>();
        int queue_try_size=sc.nextInt(),queue_Command=sc.nextInt();
        int[] size_arr= new int[queue_try_size];
        int[] in= new int[queue_try_size];
        for (int i = 0; i < queue_try_size; i++) {
            in[i]=sc.nextInt();
        }
        for (int i = queue_try_size-1; i >= 0; i--) {
            set.add(in[i]);
            size_arr[i]=set.size();
        }
        for (int i = 0; i < queue_Command; i++) {
        out.println(size_arr[sc.nextInt()-1]);
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
