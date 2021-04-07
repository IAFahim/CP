//package com.company;

import java.io.*;
import java.util.*;


public class TrickySum {
    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();
        int till = sc.nextInt();
        int i = 0;
        while (i < till) {
            long p = 1;
            long num = sc.nextLong();
            long sum_to_n = (num * (num + 1)) / 2;//if(n==7) 1+2+3+4+5+6=Sum_to_n
            long pow_pow_Inc_rea_ser=1;//starts from 1
            long sum_of_pow_pow=0;//starts form 0
            while (pow_pow_Inc_rea_ser <= num) {
                sum_of_pow_pow+=pow_pow_Inc_rea_ser;
                pow_pow_Inc_rea_ser*=2;//pow 1,2,4,16,... dont worry we will dobule this fool
            }
            long answer=sum_to_n-sum_of_pow_pow*2;
            out.println(answer);
            i++;
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
//--------------------------------------------------------
