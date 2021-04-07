//package com.company;
import java.io.*;
//import java.lang.reflect.Array;
import java.util.*;
public class Throwingcardsawayi {
//    public class Main {

    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        while (true){
        Vector vector=new Vector();
        Queue<Integer> queue= new LinkedList<>();
            long x=sc.nextLong();
            if(x==0)break;
            if(x==1){
                out.println("Discarded cards:");
                out.println("Remaining card: 1");
            }
            else{
                for (int i = 1; i <= x; i++) {
                    queue.add(i);
                }
                while (queue.size()>=2){
                    vector.add(queue.poll());
                    queue.add(queue.poll());
                }
                out.print("Discarded cards: ");
                int i;
                for ( i = 0; i < vector.size()-1; i++) {
                    out.print(vector.elementAt(i)+", ");
                }
                    out.println(vector.elementAt(i));
                out.println("Remaining card: "+queue.poll());


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
