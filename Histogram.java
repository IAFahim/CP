//package com.company;

import java.io.*;
import java.util.*;

public class Histogram {
    //public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till = sc.nextInt();
        for (int z = 0; z < till; z++) {

            Stack<Integer> stack = new Stack<>();
            int x = sc.nextInt(), maxArea = 0, top = 0, area = 0, i = 0;
            int[] cuurentbar_lenth = new int[x];
            for (i = 0; i < x; i++) {
                cuurentbar_lenth[i] = sc.nextInt();
            }
            i = 0;
            while (i < x) {
                if (stack.empty() || cuurentbar_lenth[stack.peek()] < cuurentbar_lenth[i]) {
                    stack.add(i++);
                } else {
                    top = stack.pop();
                    if (!stack.empty())
                        area = cuurentbar_lenth[top] * (i - 1 - stack.peek());
                    else area = cuurentbar_lenth[top] * i;
                    maxArea = Math.max(area, maxArea);
                }

            }
            while (!stack.empty()) {
                top = stack.pop();
                if (!stack.empty())
                    area = cuurentbar_lenth[top] * (i - 1 - stack.peek());
                else area = cuurentbar_lenth[top] * i;
                maxArea = Math.max(area, maxArea);
            }


            out.println("Case " + (z + 1) + ": " + maxArea);
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
