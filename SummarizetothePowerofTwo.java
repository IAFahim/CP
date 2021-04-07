package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class SummarizetothePowerofTwo {
    //public class Main {
    static boolean isPowerOfTwo(int x)
    {
        /* First x in the below expression is
        for the case when x is 0 */
        return x != 0 && ((x & (x - 1)) == 0);
    }

    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int n = sc.nextInt();
        int[] a= new int[n];
        Map<Integer, Integer>aMap=new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        int conter=0;
        for (int i = 0; i < n; i++) {
            aMap.put(a[i],aMap.getOrDefault(a[i],0)+1);
        }

        out.println(a.length-(int) Arrays.stream(a).filter((x->IntStream.rangeClosed(1,31).anyMatch(i->{
            int other=(1<<i)-x;
            if(other==x){
                return aMap.get(x)>=2;
            }else {
                return aMap.containsKey(other);
            }
        }))).count());
        out.close();
        //COULDNT SOLVE IT DONT LOOK AT ME I AM HORRIABLE
        //GOOD NEWS I KNEW NOW, I DONT KNOW SHIT ABOUT JAVA
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
