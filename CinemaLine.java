package com.company;

import java.io.*;
import java.util.*;

public class CinemaLine {
//    public class Main {
    public static

    void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till = sc.nextInt();
        boolean bool = true;
        int cange_25_count = 0;
        int taka50_cange_25_count = 0;
        for (int i = 1; i <= till; i++) {
            int next = sc.nextInt();
            if (next == 25) cange_25_count++;
            if (next == 50)
                if (cange_25_count >= 1) {
                    taka50_cange_25_count++;
                    cange_25_count--;
                } else {
                    bool = false;
                    break;
                }
            if (next == 100) {
                if (cange_25_count >= 1 && taka50_cange_25_count >=1) {
                    cange_25_count--;
                    taka50_cange_25_count--;
                }else if(cange_25_count>=3){
                    cange_25_count-=3;
                }
                else {
                    bool = false;
                    break;
                }
            }
        }
        out.println(bool ? "YES" : "NO");
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
