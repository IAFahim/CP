//package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CentroidDecomposition {
//    public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        long[] arr=new long[5];
        for (int i = 0; i <5 ; i++) {
            arr[i]=sc.nextInt();
        }
        long max=arr[0],min=Arrays.stream(arr).sum(),temp=arr[0];
        for (int i = 0; i < 5; i++) {
            temp=arr[i];
            arr[i]=0;
            max=Math.max(Arrays.stream(arr).sum(),max);
            min=Math.min(Arrays.stream(arr).sum(),min);
            arr[i]=temp;
        }
        out.print(min+" "+max);
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
