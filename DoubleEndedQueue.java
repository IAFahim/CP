//package com.company;

import java.io.*;
import java.util.*;

public class DoubleEndedQueue {
    //public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till = sc.nextInt();
        for (int i = 1; i <= till; i++) {
            out.println("Case " + i + ":");
            int size = sc.nextInt();
            Deque<Integer> deque = new LinkedList<Integer>();
            int again = sc.nextInt();
            for (int j = 0; j < again; j++) {
                String in = sc.next();
                if (in.charAt(1) == 'u') {
                    int temp = sc.nextInt();
                    if (size > deque.size()) {
                        if (in.charAt(4) == 'L') {
                            deque.addFirst(temp);
                            out.println("Pushed in left: " + temp);
                        } else {
                            deque.addLast(temp);
                            out.println("Pushed in right: " + temp);
                        }
                    } else {
                        out.println("The queue is full");
                    }
                } else {
                    if (deque.size() != 0) {

                        if (in.charAt(3) == 'L') {
                            out.println("Popped from left: " + deque.pollFirst());
                        } else {
                            out.println("Popped from right: " + deque.pollLast());
                        }
                    } else {
                        out.println("The queue is empty");
                    }

                }

            }
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
