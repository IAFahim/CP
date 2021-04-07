//package com.company;
//
import java.io.*;
import java.sql.Array;
import java.sql.Connection;
import java.util.*;

public class TrailingZeroes3 {
//    public class Main {
    static long findTrailingZeros(long n)
    {
        // Initialize result
        long sum=0,mul=5;
        while(mul<=n)
        {
            sum+=(n/mul);
            mul*=5;
        }
        return sum;
        // Keep dividing n by powers
        // of 5 and update count
    }
    static long firstocrencee(long x)
    {
        long low=1,high=10000000000L,ans=-1;
        while(low<high)
        {
            long mid=(low+high)/2;
            long z=findTrailingZeros(mid);
            if(z==x) ans=mid;
            if(z<x) low=mid+1;
            else high=mid;
            //printf("low:: %lld high:: %lld mid::%lld\n",low,high,mid);

        }
        //printf("low:: %lld high:: %lld mid::%lld\n",low,high,ans);
        return ans;
    }
//    static int binarySearch(int key) {
//
//        int l = 0, r = n - 1;
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//
//            if (a[mid] < key) {
//                return mid; // found //
//            } else if (a[mid] < key) {
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//            }
//        }
////        return -1; // not found //
//    }
    public static void main(String[] args) {
        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till=sc.nextInt();
        for (int z = 0; z < till; z++) {
            long current=sc.nextLong(),ans= firstocrencee(current);
            out.println("Case "+(z+1)+": "+(ans!=-1?ans:"impossible"));

        }
        out.close();
    }


    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------~
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
