package com.company;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;

class HighestandLowest {
    public static String highAndLow(String numbers) {
        // Code here or
        String[] str=numbers.split(" ");
        int max=Integer.parseInt(str[0]);
        int min=Integer.parseInt(str[0]);
        for (int i = 1; i < str.length; i++) {
            max=Math.max(max,Integer.parseInt(str[i]));
            min=Math.min(min,Integer.parseInt(str[i]));
        }
        return max+" "+min;
    }

    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        out.println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
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
