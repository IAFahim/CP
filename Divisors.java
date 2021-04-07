//package com.company;

import java.io.*;
import java.util.*;

public class Divisors {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till = sc.nextInt();
        while (till > 0) {
            till--;
            int stat,a, b, max = 0, count = 0,max_at=0;
            a = sc.nextInt();
            stat=a;
            b = sc.nextInt();
            for (; a <= b; a++) {
                count = 0;
                for (int i = 1; i * i <= a; i++) {
                    if (a % i == 0) {
                        if(i*i==a){
                            count+=1;
                            break;
                        }
                        count+=2;
                    }
                }
                if (max < count) {
                    max = count;
                    max_at=a;
                }
            }
            System.out.printf("Between %d and %d, %d has a maximum of %d divisors.\n",stat,b,max_at,max);
        }
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
