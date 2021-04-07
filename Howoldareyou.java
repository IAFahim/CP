package com.company;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Howoldareyou {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int n = sc.nextInt();
        String[] input = new String[n];
        String[] input1 = new String[n];
        String fool;
        int[] today = new int[n];
        int[] birInts = new int[n];
        for (int x = 0; x < n; x++) {
            input = sc.nextLine().split("/");
            input1 = sc.nextLine().split("/");
            fool = sc.nextLine();
            today[x] = Integer.parseInt(input[x]);
            birInts[x] = Integer.parseInt(input[x]);
            out.println(today[x]);
            out.println(birInts[x]);
        }
        out.println();
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
