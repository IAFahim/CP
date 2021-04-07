//package com.company;

import java.io.*;
import java.util.*;

public class PrimaryArithmetic {
//    public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        while (true) {
            int sum = 0;
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (a == 0 && b == 0)
                break;
            long aa, bb, extra=0;
            while (a != 0 || b != 0) {
                aa = a % 10;
                a /= 10;
                bb = b % 10;
                b /= 10;
                if ((aa + bb + extra) >= 10) {
                    sum += 1;
                    extra = 1;
                } else
                    extra = 0;
            }
            if (sum == 0){
                out.println("No carry operation.");
            }
            else if(sum==1){
                out.println("1 carry operation.");
            }
            else{
                out.println(sum + " carry operations.");
            }
        }
        out.close();
    }


    //-----------PrintWriter for faster output-dd--------------------------------
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
