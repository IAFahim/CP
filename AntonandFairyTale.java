package com.company;
//copied it full
// just to grap it
//https://www.desmos.com/calculator/q2ejyr6gse
import java.io.*;
import java.util.*;

public class AntonandFairyTale {
//    public class Main {


    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int storageLimit=sc.nextInt(),dailyAdd=sc.nextInt();
        if(storageLimit<=dailyAdd){
            out.println(storageLimit);//3 <10..in
            //1 sp
            //2 sp
            //3 sp
        }else {

        storageLimit-=dailyAdd;
        long start=0,stretch=(long)2e9,mid=0,currentJ=0;
        while (start < stretch) {
            mid=(start+stretch)/2;
            currentJ=mid*(mid+1)/2;
                            //      .      /  down
                            //     .      /
                            //   .       /
                            //.         /  <<--
            // its kinda like finding the value of theta in ml

            if (currentJ>=storageLimit)
            stretch=mid;
            else
            start=mid+1;
        }
        out.println(dailyAdd+start);
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
