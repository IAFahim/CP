//package com.company;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BasicallySpeaking {
//        public class Main {
    public static void main(String[] args) throws IOException {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s=Integer.toString(Integer.parseInt(sc.next(), sc.nextInt()), sc.nextInt());
            if(s.length()>7){
                System.out.println("  ERROR");
            }
            else{
                System.out.format("%7s\n",s.toUpperCase());
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
