//package com.company;

import java.io.*;
import java.util.*;

public class IfterParty {
//        public class Main {
    public static ArrayList<Long> getDivisors(long n, long s) {
        ArrayList<Long> divisors = new ArrayList<>();
        for (long i = 1; i * i <= n; ++i)
            if (n % i == 0) {
                if (i > s) divisors.add(i);
                if ((n / i) != i && (n / i) > s) divisors.add(n / i);
            }
        if(s==0&&n+s==0)
            divisors.add(1L);
        Collections.sort(divisors);
        return divisors;
    }

    public static void main(String[] args) {
        // new new nmewee lol wait sorry
        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till = sc.nextInt();
        int k = 0;
        while (till > k++) {
            long f = sc.nextLong();
            long s = sc.nextLong();
            out.print("Case " + k + ":");
            ArrayList<Long> div = getDivisors(f - s, s);
            if (div.size() == 0) {
                out.println(" impossible");
                continue;
            }
            for (long i : div) {
                if (i >= s) {
                    out.print(" " + i);
                }
            }
            out.println();
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
