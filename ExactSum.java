package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class ExactSum  {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] a= new int[100009];
        String line,ans="";
        StringTokenizer st;
        while ((line=br.readLine())!=null) {
            int n=Integer.parseInt(line);
            st=new StringTokenizer(br.readLine());
            for (int i = 0; i <n; i++) {
                a[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a,0,n);
            int find=Integer.parseInt(br.readLine()),x=0,y=1;
            for (int l = 0,r=n-1; l<r; l++) {
                while (l<r && a[l]+a[r]>find)r--;
                if(l<r && a[l]+a[r]==find){
                    x=l;
                    y=r;
                }
            }
            br.readLine();
            ans+="Peter should buy books whose prices are "+a[x]+" and "+a[y]+".\n\n";
        }
        System.out.print(ans);
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