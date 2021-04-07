//package com.company;

import java.io.*;
import java.util.*;

public class DivisorsofTwoIntegers {
//    public class Main {

    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for (int z = 0; z < till; z++) {
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);
        int totalmax=arr.get(--till);
        out.print(totalmax+" ");
        for (int i = --till; i>=0; i--) {
            if (totalmax % arr.get(i) != 0||arr.get(i).equals(arr.get(i+1))) {
                out.println(arr.get(i));break;
            }
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
