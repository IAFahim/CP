//package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CountingWeekendDays {
    //public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        String day_str = "SUNMONTUEWEDTHUFRISAT";
        String mon_str = "JANFEBMARAPRMAYJUNJULAUGSEPOCTNOVDEC";
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int till=sc.nextInt();
        for (int z = 0; z < till; z++) {
            String mon =sc.next(),day=sc.next();
            int i=day_str.indexOf(day)/3+1,gap=0;
            for (int j = i; j < days[mon_str.indexOf(mon)/3]+i; j++) {
                int mod=j%7;
                if(mod==6 || mod==0)gap++;
            }
            out.println(gap);
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
