//package com.company;

import java.io.*;
import java.util.*;
//public class Main {
public class lowelements {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int n=sc.nextInt();
        String[] input = new String[n];
        input=sc.nextLine().split(" ");
        int[] arr=new int[n];
        for (int i = 0; i <n; i++) {
            arr[i]=Integer.parseInt(input[i]);
        }
        int sum=1,low=arr[0];
        for (int i = 1; i < n; i++) {
            if(arr[i]<low){sum++;low=arr[i];}//0>1
        }
        out.println(sum);
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
