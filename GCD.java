//package com.company;

import java.io.*;
import java.util.*;
class GDC {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        while (true){
        int x=sc.nextInt();
        if(x==0)
            break;
        ma m=new ma();
        int sum=0;
        for (int i = 1; i < x; i++) {
            for (int j = i+1; j <=x; j++) {
                  sum+=m.gcd(i,j);
            }
        }
        out.println(sum);
        }
        out.close();
    }
    public  static class ma {
        public int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
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
