//package com.company;
import java.io.*;
import java.util.*;

public class LeadingandTrailing {
//public class Main {
    static long bigMod ( long a, long p, long m ) { // returns (a^p) % m
            long res = 1 % m, x = a % m;
            while ( p > 0 ) {
                if ( (p & 1) > 0 ) res = ( res * x ) % m;
                x = ( x * x ) % m; p >>= 1;
            }
            return res;
        }
public static void main(String[] args) {

    out = new PrintWriter(new BufferedOutputStream(System.out));
    MyScanner sc = new MyScanner();//start
    int till=sc.nextInt();
    while (till-->0){
        long x=sc.nextLong(),p=sc.nextLong();
        double temp=Math.log10(x)*p;
        temp-=(long)temp;//can anyone do it smaller
        long fs=(long)(Math.pow(10,temp)*100) ;
        System.out.printf("%03d...%03d\n",fs,bigMod(x,p,1000));
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
