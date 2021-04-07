//package com.company;
import java.io.*;
import java.util.*;
public class IndianSummer {
//public class Main {
public static void main(String[] args) {

    out = new PrintWriter(new BufferedOutputStream(System.out));
    MyScanner sc = new MyScanner();//start
    Set<String> list = new HashSet<String>();
    int till=sc.nextInt();
    for (int i = 1; i <= till; i++) {
        String temp=sc.nextLine();
        if(!list.contains(temp)){
            list.add(temp);
        }
    }
    out.println(list.size());
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
