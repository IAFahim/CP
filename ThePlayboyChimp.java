//package com.company;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class ThePlayboyChimp {
//        public class Main {
    public static int upperBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int lowerBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            //checks if the value is less than middle element of the array
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    //    public class Main {
    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till = sc.nextInt();
        int[] a = new int[till];
        for (int z = 0; z < till; z++) {
            a[z] = sc.nextInt();
        }
        int till_s = sc.nextInt();
        int[] b = new int[till_s];
        for (int z = 0; z < till_s; z++) {
            b[z] = sc.nextInt();
        }
        for (int i = 0; i < till_s; i++) {
            int first = lowerBound(a, a.length, b[i])-1, second = upperBound(a, a.length, b[i]);
            if (first > -1 && first < till && second>0 && second<till) {
                out.println(a[first]+" "+a[second]);
            }
            else if (first > -1 && second <= till) {
                out.println(a[first] + " X");
            } else if (second > 0 && first <= till) {
                out.println("X " + a[second]);
            }else {
                out.println("X X");
            }
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
