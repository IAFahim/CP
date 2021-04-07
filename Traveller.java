//package com.company;

import java.io.*;
import java.util.*;

public class Traveller {
//    public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int n=sc.nextInt();//ordinay ticik price
        int m=sc.nextInt();//special ticket for m rides
        int a=sc.nextInt();// costs a rubles.
        int b=sc.nextInt();//special ticket for m rides cost b
        if(m*a<=b){//special tickit sucks
            out.println(n*a); //6 2 1 2
        }else{//speical tickit buy
            //(n/m)*b= total ride/ compact rides=how many you need special ticket
            //extra left over * a buy  (n%b)*a
            // or get another b  who cares
            out.println((n/m)*b+Math.min((n%m)*a,b));
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
