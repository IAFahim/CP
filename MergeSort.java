package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class MergeSort {
    //public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till=3;
        int[] arr=new int[3];
        for (int i = 0; i < till; i++) {
            arr[i]=sc.nextInt();
        }
        char[] ch=sc.nextLine().toCharArray() ;
        char[] ch_in=ch.clone();
        Arrays.sort(arr);
        Arrays.sort(ch);
        Map<Character,Integer> linkedList= new HashMap<Character, Integer>();
        for (int i = 0; i < 3; i++) {
        linkedList.put(ch[i],arr[i]);
        }
        for (int i = 0; i < 2; i++) {
            out.print(linkedList.get(ch_in[i])+" ");
        }
        out.print(linkedList.get(ch_in[2]));
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
