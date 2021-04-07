//package com.company;

import java.io.*;
import java.util.*;

public class BuyingShovels {

    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            int sovles = sc.nextInt();
            int pack_size = sc.nextInt();
            int min = sovles;
            if (pack_size >= sovles) {
                out.println(1);
                continue;
            }
            else
            for (int j = 1; j*j<=sovles; j++) {
                if(sovles%j==0){
                    if(j<=pack_size)
                        min=Math.min(sovles/j,min);
                 if(sovles/j<=pack_size)
                        min=Math.min(j,min);
                }
            }
            out.println(min);
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
