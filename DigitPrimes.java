//package com.company;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class DigitPrimes {
//    public class Main {
    static boolean check(int a){
        double b=Math.sqrt(a);
        int i=2;
        for (; i <=b ; i++) {
            if(a%i==0)break;
        }
        return i>b;
    }
    static int n=1000010;
    static boolean prime[] = new boolean[n+1];
    static int sum[] = new int[n+1];
    static void sum(){
        for (int i = 2; i <= 1000; i++) {
            if(!prime[i])
                for (int j = i*i; j <n ; j+=i) {
                    prime[j]=true;
                }
        }
        for (int i = 2; i < n; i++) {
            if(!prime[i]){
                int a=0,b=i;
                while (b>0){
                    a+=b%10;
                    b/=10;
                }
                if(check(a))
                    sum[i]++;
            }
            sum[i]+=sum[i-1];
        }
    }

    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        sum();
        int till=sc.nextInt();
        for (int z = 0; z < till; z++) {
            int a=sc.nextInt(),b=sc.nextInt();
            out.println(sum[b]-sum[a-1]);
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
