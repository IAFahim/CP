//package com.company;

import java.io.*;
import java.util.*;

public class kthdivisor {
//    public class Main {
        public static ArrayList<Long> getDivisors (long n)
            {
                ArrayList<Long> divisors = new ArrayList<>();
                for (long i = 1 ; i * i <= n ; ++i)
                    if (n % i == 0)
                    {
                        divisors.add(i);
                        if (i != n / i) divisors.add(n / i);
                    }
                return divisors;
            }
        
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        ArrayList numArrayList=getDivisors(sc.nextLong());
        Collections.sort(numArrayList);
        int to=sc.nextInt();
        out.println((numArrayList.size()>=to)?numArrayList.get(to-1):-1);
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
