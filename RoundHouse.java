//package com.company;

import java.io.*;
import java.util.*;

public class RoundHouse {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int n = 3;
        String[] input = new String[n];
        input = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int x = 0; x < n; x++) {
            arr[x] = Integer.parseInt(input[x]);
        }
        out.println((((arr[1]+arr[2]-1)%arr[0]+arr[0])%arr[0])+1);//wtffffff,,,,,,,,,,
        //so we dont let is get to its positon so we reduce it by one (cant let the fool land so easily)
        //and we get a little value which is added to the size so that we can get the value
        //this time we add back because we got it this time
        // we got the fool

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
