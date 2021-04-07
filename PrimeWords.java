//package com.company;

import java.io.*;
import java.util.*;

//public class Main {
            public class PrimeWords {
    static boolean isPrime(int n) {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    public static void main(String[] args) throws IOException {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        String Str;
        while ((Str=sc.nextLine()) != null) {
            int sum = 0;
            for (int i = 0; i < Str.length(); i++) {
                char str = Str.charAt(i);
                if ('A' <= str && str <= 'Z') {
                    sum += str - 'A' + 27;
                } else {
                    sum += str - 'a' + 1;
                }
            }
            out.println(isPrime(sum) || sum==1? "It is a prime word." : "It is not a prime word.");
        }
        out.close();
    }


    //-----------PrintWriter for faster output----aa-----------------------------
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
