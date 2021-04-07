//package com.company;

import java.io.*;
import java.util.*;


//class Main {
class MaximumGCD {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till=sc.nextInt();
        for (int j = 0; j < till; j++)

        {
            int n = 100;
            String[] input = new String[n];
            input = sc.nextLine().split(" ");
            int[] arr = new int[n];
            for (int x = 0; x < input.length; x++) {
                arr[x] = Integer.parseInt(input[x]);
            }
            int mx = 0;
            ma m = new ma();
            for (int x = 0; x < input.length; x++) {
                for (int i = x + 1; i < input.length; i++) {
                    mx = Math.max(mx, (m.gcd(arr[i], arr[x])));
                }
            }
            out.println(mx);
        }out.close();
    }


    public static class ma {
        public int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
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
