//package com.company;
import java.io.*;
import java.util.*;
public class CSUMQ {
//    public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int array_Size=sc.nextInt();
        int[] arr=new int[++array_Size];//because it starts from 1 the shitttt
        for (int i = 1; i < array_Size; i++) {
            arr[i]=arr[i-1]+sc.nextInt();
        }
        int till=sc.nextInt();
        for (int i = 1; i <= till; i++) {
            int start=sc.nextInt();
            int end_pp=sc.nextInt()+1;// added index at 1
            out.println(arr[end_pp]-arr[start]);
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
