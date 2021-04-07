package com.company;

import java.io.*;
import java.util.*;

public class KarenandCoffee {
    //public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int n=200100,additive=0,resipy=sc.nextInt(),k_what_is_this=sc.nextInt(),question=sc.nextInt();
        int[] array=new int[n];
        for (int i = 0; i < resipy; i++) {
            array[sc.nextInt()]++;
            array[sc.nextInt()+1]--;
        }
        for (int i = 0; i < n; i++) {
            additive+=array[i];
            if(additive>=k_what_is_this)
            array[i]=1;
            else
                array[i]=0;
        }
        int[] brray=new int[n];
        for (int i = 1; i < n; i++) {
            brray[i]=array[i-1]+brray[i-1];
        }
        for (int i = 0; i < question; i++) {
            int start=sc.nextInt(),end=sc.nextInt();
            out.println(brray[end+1]-brray[start]);
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
