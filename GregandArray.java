package com.company;

import java.io.*;
import java.util.*;

public class GregandArray {
    //public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int arraySize = sc.nextInt(), oporationCount = sc.nextInt(), qurySize = sc.nextInt();
        int[] array = new int[arraySize+1];
        for (int i = 0; i < arraySize; i++) {
            array[i] = sc.nextInt();
        }
        int[] leftA = new int[oporationCount+1];
        int[] rightA = new int[oporationCount+1];
        int[] addValueA = new int[oporationCount+1];
        for (int i = 0; i < oporationCount; i++) {
            leftA[i] = sc.nextInt();
            rightA[i] = sc.nextInt();
            addValueA[i] = sc.nextInt();
        }
        int[] quryXA = new int[qurySize+1];
        int[] quryYA = new int[qurySize+1];
        for (int i = 0; i < qurySize; i++) {
            quryXA[i] = sc.nextInt();
            quryYA[i] = sc.nextInt();
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
