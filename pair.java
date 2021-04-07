//package com.company;

import java.io.*;
import java.util.*;

public class pair {
    //    public class Main {
    static int countPairsWithDiffK(int arr[], int n, int k)
    {
        int count = 0;

        // Pick all elements one by one
        for (int i = 0; i < n; i++)
        {
            // See if there is a pair
            // of this picked element
            for (int j = i + 1; j < n; j++)
                if (arr[i] - arr[j] == k ||
                        arr[j] - arr[i] == k)
                    count++;
        }
        return count;
    }

    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till = sc.nextInt(), size = sc.nextInt();
        int[] arr = new int[till];
        for (int i = 0; i < till; i++) {
            arr[i] = sc.nextInt();
        }
        out.println(countPairsWithDiffK(arr,till,size));
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
