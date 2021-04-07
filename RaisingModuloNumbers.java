package com.company;

import java.io.*;
import java.util.*;

public class RaisingModuloNumbers {
    //public class Main {
    public static long powMod(long a, long b,long x){//2^8
        // remeber to senc a%10 mod here
            if(b==0) return 1;
            long n = powMod(a,b/2,x);//half half removes the extra
            long total = n*n%x;//2^4 * 2^4
            if(b%2==1) total =total*a%x;
            return total;//modified for last int
        }
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till=sc.nextInt();
        for (int i = 1; i <= till; i++) {
            long x=sc.nextLong(),to=sc.nextInt(),tempTotal=0;
            for (int j = 0; j < to; j++) {
                tempTotal+=powMod(sc.nextLong(),sc.nextLong(),x);
            }
            out.println(tempTotal%x);
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
