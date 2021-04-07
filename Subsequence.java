//package com.company;

import java.io.*;
import java.util.*;

public class Subsequence {
//        public class Main {
    public static void main(String[] args) throws IOException {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        while (sc.br.ready()){
//        int i=2;
//        while (i-->0){
        int till=sc.nextInt();
        int limit=sc.nextInt();
        Integer[] arr=new Integer[till];
        for (int z = 0; z < till; z++) {
            arr[z]=sc.nextInt();
        }
        Arrays.sort(arr,Collections.reverseOrder());
        int sum=0;
//        boolean found=false;
        for (int j = 0; j < till; j++) {
                sum+=arr[j];
                if(sum>=limit){
                    out.println(""+(j+1));
                    break;
                }
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