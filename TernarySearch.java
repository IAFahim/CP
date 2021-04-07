//package com.company;

import java.io.*;
import java.util.*;

public class TernarySearch {
//        public class Main{
    public static String longDivision(String number, int divisor) {

        // As result can be very
        // large store it in string
        // but since we need to modify
        // it very often so using
        // string builder
        StringBuilder result
                = new StringBuilder();

        // We will be iterating
        // the dividend so converting
        // it to char array
        char[] dividend
                = number.toCharArray();

        // Initially the carry
        // would be zero
        int carry = 0;

        // Iterate the dividend
        for (
                int i = 0;
                i < dividend.length; i++) {
            // Prepare the number to
            // be divided
            int x
                    = carry * 10
                    + Character.getNumericValue(
                    dividend[i]);

            // Append the result with
            // partial quotient
            result.append(x / divisor);

            // Prepare the carry for
            // the next Iteration
            carry = x % divisor;
        }

        // Remove any leading zeros
        for (
                int i = 0;
                i < result.length(); i++) {
            if (
                    result.charAt(i) != '0') {
                // Return the result
                return result.substring(i);
            }
        }
        // Return empty string
        // if number is empty
        return "";
    }

    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        String a = sc.nextLine();
        int i=1;
        if(a.equals("0")||a.equals("1")){
            out.println(1);
        }else {
        for (i=1;!a.equals("1"); i++) {
            a=longDivision(a,i);
        }
        out.println(i-1);
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
