//package com.company;

import java.io.*;
import java.util.*;

public class Updatethearray {
    //public class Main {


    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till = sc.nextInt();
        for (int i = 1; i <= till; i++) {
            int size=sc.nextInt()+1;
            int[] arr = new int[size];
            for (int j = sc.nextInt()-1; j >=0 ; j--) {
                int left=sc.nextInt(),right=sc.nextInt(),add_or_remove=sc.nextInt();
                arr[left]+=add_or_remove;
                arr[right+1]-=add_or_remove;
            }
            //prefix_builder
            for (int j = 1; j < size; j++) {
                arr[j] += arr[j - 1];
            }
            size=sc.nextInt();
            for (int j = 0; j < size; j++) {
                out.println(arr[sc.nextInt()]);
            }

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
