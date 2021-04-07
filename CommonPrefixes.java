//package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CommonPrefixes {
//    public class Main {
    public static void main(String[] args) {
        char[] arr = new char[200];
        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till = sc.nextInt();
        for (int i = 1; i <= till; i++) {
            int n = sc.nextInt();
            Arrays.fill(arr,'a');
            out.println(arr);
            for (int z = 0; z < n; ++z) {
                int u;
                u=sc.nextInt();
                arr[u] = arr[u] == 'a' ? 'b' : 'a';
                out.println(arr);
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
