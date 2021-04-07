//package com.company;
import java.io.*;
import java.util.*;
public class DigitsofFactorial {
//    public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n=1000001;
        double[] logged= new double[n];
        for (int i = 1; i < n; i++) {
            logged[i]=logged[i-1]+Math.log(i);
        }
        MyScanner sc = new MyScanner();//start
        int till=sc.nextInt(),k=0;
        while (till>k++){
            double x=sc.nextDouble();
            double d=sc.nextDouble();
            int ans =(int)Math.ceil(logged[(int)x]/Math.log(d));
            ans=(ans == 0)? 1: ans;
            out.println("Case "+k+": "+ans);
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
