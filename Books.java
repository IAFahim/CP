//package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Books {

//public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int i = 0, book = sc.nextInt(), time = sc.nextInt();//,min=Math.min(time,book);
        int[] arr = new int[book];
        for (i = 0; i < book; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0, j = 0, total = 0;
        for (i = 0; i < book; i++) {
            sum += arr[i];
            if (sum <= time) {
                total++;
            } else {
                sum -= arr[j];
                j++;
            }
        }

        out.println(total);
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
