package com.company;
import java.io.*;
import java.util.*;
public class AlternateTask {
//    public class Main {
    static int n=1000;
    public static int[] index =new int[++n];
    static void indexingofSumofDivisors_till(){
        for (int i = 1; i < n; i++) {
            int temp=(int)SumOfDivisors(i);
            if(temp<=1000)
                index[temp]=i;
        }
    }// er kasy bechar delam
    static long SumOfDivisors(long x) {
        if (x == 1) return 1;
        long i, ans = 1, sq = (long) Math.sqrt(x);
        for (i = 2; i <= sq; i++) {
            if (x % i == 0)
                if (i * i == x) ans += i;
                else ans += i + x / i;
        }
        return ans + x;
    }
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        indexingofSumofDivisors_till();
        int i = 1;
        while (true) {
            int x = sc.nextInt();
            if (x == 0) break;
            out.println("Case " + i + ": " +(index[x]!=0?index[x]:-1));
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
