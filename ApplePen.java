//package com.company;

import java.io.*;
import java.util.*;

public class ApplePen {
//        public class Main {
    public static void main(String[] args) throws IOException {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till=sc.nextInt();
        for (int z = 0; z < till; z++) {
            String a=sc.nextLine();
            String b=sc.nextLine();
            out.println("Uh! "+b.substring(9)+"-"+a.substring(9)+"!");
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