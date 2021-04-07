//package com.company;
import java.io.*;
import java.util.*;
public class Aatc {
//    public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int a=sc.nextInt();
        Map<String,Integer> ver = new HashMap<String, Integer>();
        ver.put("AC",0);
        ver.put("WA",0);
        ver.put("TLE",0);
        ver.put("RE",0);
        for (int i = 0; i <a; i++) {
            String temp=sc.nextLine();
            ver.merge(temp,1,Integer::sum);
        }
        System.out.println("AC" + " x "+ ver.get("AC"));
        System.out.println("WA" + " x "+ ver.get("WA"));
        System.out.println("TLE" + " x "+ ver.get("TLE"));
        System.out.println("RE" + " x "+ ver.get("RE"));
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
