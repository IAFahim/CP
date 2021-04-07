//package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class ArrayNegations {
//            public class Main {
    public static int maxSum(int[] a, int k) {
        // Create a priority queue and insert all array elements
        // int
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : a)
            pq.add(x);

        // Do k negations by removing a minimum element k times
        while (k-- > 0) {
            // Retrieve and remove min element
            int temp = pq.poll();

            // Modify the minimum element and add back
            // to priority queue
            temp *= -1;
            pq.add(temp);
        }

        // Compute sum of all elements in priority queue.
        int sum = 0;
        for (int x : pq)
            sum += x;
        return sum;
    }

    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till = sc.nextInt();
        for (int i = 1; i <= till; i++) {
            int arraySize = sc.nextInt(), NagationCount = sc.nextInt();
            int[] array = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                array[j] = sc.nextInt();
            }
            out.println(maxSum(array, NagationCount));
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
