package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class RobotsTask {
    //public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till=sc.nextInt(),derectionChangeCount=0,currentHigh=0,zeroCount=0;
        ArrayList<Integer> lineUp=new ArrayList<Integer>();
        for (int z = 0; z < till; z++) {
            lineUp.add(sc.nextInt());
        }
        int i=0;
        while (true){
            while ( i < lineUp.size()) {
                if(currentHigh>=lineUp.get(i)){
                    currentHigh=Math.max(lineUp.get(i),currentHigh+1);
                    lineUp.remove(i);
                    zeroCount++;
                    continue;
                }
                i++;
            }
            i--;
            if(zeroCount==till)break;
            derectionChangeCount++;
            while (i >= 0) {
                if(currentHigh>=lineUp.get(i)){
                    currentHigh=Math.max(lineUp.get(i),currentHigh+1);
                    lineUp.remove(i);
                    zeroCount++;
                }
                i--;
            }
            i++;
            if(zeroCount==till)break;
            derectionChangeCount++;
        }
        out.println(derectionChangeCount);
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
