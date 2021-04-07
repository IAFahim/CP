//package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Aggressivecows {
    static int f(int n, int distinct, int[] a) {
        int count = 1, prev = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] - prev >= distinct) {
                count++;
                prev = a[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till = sc.nextInt();
        for (int z = 0; z < till; z++) {
            int n = sc.nextInt(), cows = sc.nextInt(), a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int l = 0, r = (int) 1e9 + 100;
            while (r - l > 1) {
                int mid = l + (r - l) / 2;
                if (f(n, mid, a) >= cows) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            out.println("" + (l + (r - l) / 2));
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
