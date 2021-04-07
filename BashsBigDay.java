//package com.company;

import java.io.*;
import java.util.*;

public class BashsBigDay {
//public class Main {


    public static void main(String[] args) {

            out = new PrintWriter(new BufferedOutputStream(System.out));
            MyScanner sc = new MyScanner();//start
            HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
            int max=0;
            int size=sc.nextInt();
            for (int i = 0; i < size; i++) {
                int temp=sc.nextInt();
                if(max<temp)
                    max=temp;
                map.put(temp,map.getOrDefault(temp,0)+1);
        }//gets the max
            Boolean[] bool=new Boolean[max+1];
            Arrays.fill(bool,Boolean.FALSE);
            int High=1;
        for (int i = 2; i <= max; i++) {
            int temp_count=0;
            for (int j = i; j <= max; j+=i) {
                if(bool[j]==false)
                    bool[j]=true;
                    temp_count+=map.getOrDefault(j,0);
            }
            High=Math.max(temp_count,High);
        }
            out.println(High);
            out.close();
        }


        //-----------PrintWriter for faster output-------------------dsd--------------
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

            String nextLine(){
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
