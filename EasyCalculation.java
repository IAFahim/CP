//package com.company;

import java.io.*;
import java.util.*;

class EasyCalculation {
    static double bisecton_itter(double A,double B,double C) {
        double l=0,r=C,mid=(l+r)/2;
        for (int i = 0; i < 80; i++) {
            mid=(l+r)/2;
            double cur=A*mid+B*Math.sin(mid);
            if(cur>C){
                r=mid;
            }else if (cur<C){
                l=mid;
            }
        }
        return mid;
    }
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till=sc.nextInt();
        for (int z = 0; z < till; z++) {
            double A=sc.nextDouble(),B=sc.nextDouble(),C=sc.nextDouble();
            out.format("%.6f\n",bisecton_itter(A,B,C));
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
