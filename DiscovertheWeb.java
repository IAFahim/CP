//package com.company;

import java.io.*;
import java.util.*;

public class DiscovertheWeb {
//        public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till = sc.nextInt();
        for (
                int i = 1;
                i <= till; i++) {
            String str;
            List<String> list = new LinkedList<String>();
            list.add("http://www.lightoj.com/");
            out.println("Case " + i + ":");
            int currentPage = 0;
            int pagecount = 1;
            while (true) {
                str = sc.nextLine();
                if (str.charAt(0) == 'V') {
                    currentPage++;
                    list.add(currentPage, str.substring(6));
                    out.println(str.substring(6));
                    pagecount = currentPage + 1;
                } else if (str.charAt(0) == 'B') {
                    if (0 < currentPage) {
                        //Collections.swap(list,currentPage,currentPage-1);
                        out.println(list.get(--currentPage));
                    } else {
                        out.println("Ignored");
                    }
                } else if (str.charAt(0) == 'F') {
                    if (currentPage != pagecount - 1) {
                        //Collections.swap(list,currentPage+1,currentPage+1);
                        out.println(list.get(++currentPage));
                    } else {
                        out.println("Ignored");
                    }
                } else
                    break;
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
