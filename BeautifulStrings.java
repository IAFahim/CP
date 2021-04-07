package com.company;

import java.io.*;
import java.util.*;

public class BeautifulStrings {
    //public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        Map<Character, Integer>map=new HashMap<>();
        String string= sc.nextLine();
        for (int i = 0; i <string.length() ; i++) {
            if(!map.containsKey(string.charAt(i))){
                map.put(string.charAt(i),1);
            }else {
                map.put(string.charAt(i),map.get(string.charAt(i))+1);
            }
        }
        for(var i: map.entrySet()){
            if(i.getValue()%2!=0){
                out.println("No");
                out.close();
                return;
            }
        }
        out.println("Yes");
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
