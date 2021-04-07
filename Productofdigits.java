//package com.company;
//
import java.io.*;
import java.util.*;

public class Productofdigits {
//    public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till = sc.nextInt();
        for (int i = 1; i <= till; i++) {
            int x= sc.nextInt(),temp=x;
            if(x<2) {
            out.println(x);
            continue;
            }
            StringBuilder str=new StringBuilder();
            for (int j = 9; j > 1; j--) {
                while (x%j==0){
                    x/=j;
                    str.append(j);
                }
            }
            char[] c=str.toString().toCharArray();
            Arrays.sort(c);
            out.println(x==1? String.copyValueOf(c):-1);
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
