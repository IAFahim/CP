package com.company;

import java.io.*;
import java.util.*;

public class HanSoloandLazerGun {
//    public class Main {
    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int count=sc.nextInt(),perpendicular=Integer.MAX_VALUE;
        double start_x=sc.nextDouble(),start_y=sc.nextDouble();
        double[] slope=new double[count];
        for (int i = 0; i < count; i++) {
            double points_x=sc.nextDouble(),points_y=sc.nextDouble();
            if(start_x!=points_x)slope[i]=(points_y-start_y)/(points_x-start_x);//or
            else slope[i]=perpendicular;
        }
        Arrays.parallelSort(slope);
        int different=0;
        double temp=Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            if(slope[i]!=temp){
                different++;
                temp=slope[i];
            }
        }
        out.println(different);
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
