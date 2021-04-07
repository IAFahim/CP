//package com.company;
import java.io.*;
import java.util.*;
public class ATrivialProblem {
//public class Main {
public static int findTrailingZeros(int n) {
    int count=0;
    while(0<n){
        n /= 5;
        count += n;
    }
    return count;
}
public static void main(String[] args) {
    out = new PrintWriter(new BufferedOutputStream(System.out));
    MyScanner sc = new MyScanner();//start
    int till=sc.nextInt(),size=0,i=4*till;//
    while (0<i++) {
        int fx=findTrailingZeros(i);
        if(fx==till){
            size++;
            out.print(i+" ");
        }
        if(fx>till)
            break;
    }
    System.out.println(size);
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
