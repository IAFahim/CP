package com.company;

import java.io.*;
import java.util.*;

public class ParallelogramisBack {
    //public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int zero=0,cordenetsCount=3,a=zero,b=1,c=2,stepdown=cordenetsCount-1;
        int[] x=new int[cordenetsCount];
        int[] y=new int[cordenetsCount];
        int[] varteses=new int[cordenetsCount];
        for (int z = 0; z < cordenetsCount; z++) {
            x[z]=sc.nextInt();
            y[z]=sc.nextInt();
        }
        out.println(cordenetsCount);
        for (int i = 0; i < cordenetsCount; i++) {
            a=(a==stepdown)?zero:a+1;b=(b==stepdown)?zero:b+1;c=(c==stepdown)?zero:c+1;
            out.println((x[a]+x[b]-x[c])+" "+(y[a]+y[b]-y[c])+" ");
        }// i need a doctor
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
