//package com.company;

import java.io.*;
import java.util.*;

public class Divideit {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int n=sc.nextInt();
        while (0<n--){
            long x =sc.nextLong();
            int two=0,three=0,five=0;
            while(x%2==0){x/=2;two++;}
            while(x%3==0){x/=3;three++;}
            while(x%5==0){x/=5;five++;}
            if(x==1){
                out.println(two+three*2+five*3);//why 3 good question //no idea
            }else {
                out.println(-1);
            }
        }
        out.println();
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
