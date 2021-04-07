//package com.company;

import java.io.*;
import java.util.*;

public class ErasingZeroes {
    public static void main(String[] args) {


        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            int zero = 0,low=-1,high=-1;
            String str = sc.nextLine();
            for (int n = 0; n < str.length(); n++) {//0 is must or it will not get the first 1
                if(str.charAt(n)=='1') { low = n;break; }//we got the low now look for 0
            }
            for (int k = str.length()-1; k > 0; k--) {//last one zero or 1 doesnt matter
                if(str.charAt(k)=='1'){ high = k;break; }//make a container
            }//container done now hunt for 0
            if(low!=-1 && high!=-1)//shit moved hunt beguns
            for (int z = low; z <= high; z++) {
                if(str.charAt(z)=='0'){zero++;}//take all zeros
            }
            out.println(zero);
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
