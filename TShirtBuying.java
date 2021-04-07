//package com.company;


import java.io.*;
import java.util.*;

public class TShirtBuying {
    //    public class Main {
    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int sizeOfshirt = sc.nextInt();
        ArrayList<Integer> shirtArray = new ArrayList<>();
        TreeSet<Integer>[] frontprossesingTreeSets = (TreeSet<Integer>[]) new TreeSet[4];
        TreeSet<Integer>[] backproseeingTree = (TreeSet<Integer>[]) new TreeSet[4];
        for (int i = 0; i < 4; i++) {
            //active
            frontprossesingTreeSets[i] = new TreeSet<>();
            backproseeingTree[i] = new TreeSet<>();
        }
        for (int i = 0; i < sizeOfshirt; i++) {
            shirtArray.add(sc.nextInt());
        }
        for (int i = 0; i < sizeOfshirt; i++) {
            frontprossesingTreeSets[sc.nextInt()].add(shirtArray.get(i));
        }
        for (int i = 0; i < sizeOfshirt; i++) {
            backproseeingTree[sc.nextInt()].add(shirtArray.get(i));
        }
        ArrayList<Integer> coustomerArray = new ArrayList<>();
        int sizeOfCoustomer = sc.nextInt();
        for (int i = 0; i < sizeOfCoustomer; i++) {
            coustomerArray.add(sc.nextInt());
        }
        for (int i = 0; i < sizeOfCoustomer; i++) {
            int front = -1, back = -1,color=coustomerArray.get(i);
            if(frontprossesingTreeSets[color].size()!=0){
                front=Math.max(front,frontprossesingTreeSets[color].first());
            }
            if(backproseeingTree[color].size()!=0){
                back=Math.max(back,backproseeingTree[color].first());
            }
            if(front==-1){
                out.print(back+" ");
                for (int j = 0; j < 4; j++) {
                    frontprossesingTreeSets[j].remove(back);
                    backproseeingTree[j].remove(back);
                }
            }else if(back==-1){
                out.print(front+" ");
                for (int j = 0; j < 4; j++) {
                    frontprossesingTreeSets[j].remove(front);
                    backproseeingTree[j].remove(front);
                }
            }else{
                int min=Math.min(front,back);
                out.print(min+" ");
                for (int j = 0; j < 4; j++) {
                    frontprossesingTreeSets[j].remove(min);
                    backproseeingTree[j].remove(min);
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
