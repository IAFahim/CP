package com.company;

import java.io.*;
import java.util.*;

class ExesandOhs {
    public static boolean getXO (String str) {

        // Good Luck!!
        int x=0;
        int o=0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='x'||str.charAt(i)=='X'){
                x++;
            }
            if(str.charAt(i)=='o'||str.charAt(i)=='O'){
                o++;
            }
        }
        return (x==0 && o==0) || x==o;
    }
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        out.println(getXO("ooxXm"));
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
