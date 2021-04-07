//package com.company;

import java.io.*;
import java.util.*;

public class LCMCardinality {
//            public class Main {

    public static ArrayList<Long> getDivisors(long n) {
        ArrayList<Long> divisors = new ArrayList<>();
        for (long i = 1; i * i <= n; ++i)
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) divisors.add(n / i);
            }
        return divisors;
    }


    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        while (true) {
            long x = sc.nextInt(),ans=1,temp=x;
            if (x == 0) break;
            for (long i = 2; i*i <= temp; i++) {
                if(temp%i==0){
                    int rev=0;
                    while (temp%i==0){
                        temp/=i;
                        rev++;
                    }
                    ans=ans*((rev*2)+1);
                }
            }
            if(temp!=1) ans*=3;
            out.println(x+" "+((ans/2)+1));
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
