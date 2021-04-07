package com.company;
import java.io.*;
import java.util.*;
public class EasyQueue {
//public class Main {
public static void main(String[] args) {

    out = new PrintWriter(new BufferedOutputStream(System.out));
    MyScanner sc = new MyScanner();//start
    Stack<Integer> queee=new Stack<Integer>();
    int till=sc.nextInt();

    for (int i = 1; i <= till; i++) {
        int pick=sc.nextInt();
        if(pick==1){
            queee.add(sc.nextInt());
        }else if(pick==2){
            if(!queee.isEmpty())
            queee.pop();
        }else {
            if(queee.isEmpty())
                out.println("Empty!");
            else
            out.println(queee.peek());
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
