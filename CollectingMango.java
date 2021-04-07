//package com.company;
import java.io.*;
//import java.lang.reflect.Array;
import java.util.*;
public class CollectingMango {
//public class Main {/**/
public static void main(String[] args) {
    int[] vector= new int[100001];
    int[] maxtracker= new int[100001];
    out = new PrintWriter(new BufferedOutputStream(System.out));
    MyScanner sc = new MyScanner();//start
    int till=sc.nextInt();
    for (int i = 1; i <= till; i++) {
        int command_size=sc.nextInt();
        out.println("Case "+i+":");
        int max=0;
        int size=0;
        for (int j = 0; j < command_size; j++) {
            char BOink=sc.next().charAt(0);
            if(BOink=='A'){
                int boop=sc.nextInt();
                vector[size]=boop;
                if(boop>max){
                    max=boop;
                }
                maxtracker[size]=max;
                size++;
            }
            else if(BOink=='R'){
                if(size==0) continue;
                vector[size]=0;
                maxtracker[size]=0;
                size--;
            }
            else {
                out.println(size==0?"Empty":maxtracker[size-1]);
            }
        }
//A x, here x is picked up mango size.
// R, throw out last picked up mango from basket.
// Q Find out the biggest size mango.
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
