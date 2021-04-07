//package com.company;

import java.io.*;
import java.util.*;

public class DivisorSummation {
//public class Main {
    public static class sod {
        int N = 500000;
        int[] SOD = new int[N + 1];

        public void generateSOD() {
            for (int i = 1; i <= N; i++) {
                for (int j = i; j <= N; j += i) {
                    SOD[j] += i;
                }
            }
        }
    }

    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        sod s = new sod();
        s.generateSOD();
        int till = sc.nextInt();
        for (int i = 0; i < till; i++) {
            int pick = sc.nextInt();
            out.println(s.SOD[pick] - pick);
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
