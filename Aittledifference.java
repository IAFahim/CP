//package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Aittledifference {
//    public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till=sc.nextInt();
        for (int i = 1; i <= till; i++) {
            int n=sc.nextInt();int count=0;
            int[] array=new int[n];
            for (int j = 0; j < n; j++) {
                array[j]=sc.nextInt();
            }
            Arrays.sort(array);
            for (int j = 0; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                if (Math.abs(array[j]-array[k])>1) {
                    break;
                }else {
                    count=Math.max(k-j,count);
                }
                }
            }
            out.println(count+1);
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
