package com.company;

import java.io.*;
import java.util.*;

public class TtShirtBuying {
    //public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int numberOfShirts,numberOfCustomers;
        ArrayList<Integer>priceList=new ArrayList<>();
        ArrayList<Integer>customerList=new ArrayList<>();
        TreeSet<Integer>[] frontProssingSets=(TreeSet<Integer>[]) new TreeSet[4];
        TreeSet<Integer>[] backProssingSet=(TreeSet<Integer>[]) new TreeSet[4];
        for (int i = 0; i < 4; i++) {
            frontProssingSets[i]=new TreeSet<Integer>();
            backProssingSet[i]=new TreeSet<Integer>();
        }int till=sc.nextInt();
        for (int i = 0; i < till; i++) {
            priceList.add(sc.nextInt());
        }
        for (int i = 0; i < till; i++) {
            frontProssingSets[sc.nextInt()].add(priceList.get(i));
        }
        for (int i = 0; i < till; i++) {
            backProssingSet[sc.nextInt()].add(priceList.get(i));
        }
        int NoOfCustomer=sc.nextInt();
        for (int i = 0; i < NoOfCustomer; i++) {
            customerList.add(sc.nextInt());
        }
        if(true){
            
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
