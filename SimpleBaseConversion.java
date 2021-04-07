package com.company;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class SimpleBaseConversion {
//    public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        while (true){
            String num=sc.nextLine();
            boolean coverted=false;
            if(num.charAt(0)=='-')break;
            if(num.length()>2){
            if(num.charAt(1)=='x'){
                out.println(new BigInteger(num.substring(2),16));
                coverted=true;
            }
            }if(!coverted)
                out.println("0x"+new BigInteger(num).toString(16).toUpperCase());
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
