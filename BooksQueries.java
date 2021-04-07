//package com.company;

import java.io.*;
import java.util.*;

public class BooksQueries {
//    public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int n = sc.nextInt();
        int[] arr = new int[200100];
        sc.next();
        sc.nextInt();
        int l = -1, r = 1;
        for (int i = 1; i < n; i++) {
            String pick = sc.next();
            int add_find=sc.nextInt();
            if (pick.equals("L")) {
                arr[add_find] = l--;
            } else if (pick.equals("R")) {
                arr[add_find] = r++;
            } else {
                out.println(Math.min(Math.abs(arr[add_find]-l),Math.abs(arr[add_find]-r))-1);
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
