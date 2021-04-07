//package com.company;

import java.io.*;
import java.util.*;

//public class Main {
public class SumOfDivisors {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        int n=1000001,m=3392929,n5=5000000;
        int sum[]=new int[n--];
        int count[]=new int[m];
        for (int i = 2; i <= n5; i++) {
            for (int j = 2; i*j <= n; j++) {
                sum[i*j]+=i;
            }
        }
        for (int i = 1; i <= n; i++) {
            count[sum[i]+1]++;
        }
        for (int i = 1; i < m; i++) {
            count[i]+=count[i-1];
        }m--;
        while (sc.hasNext()){
            int x=sc.nextInt();
            out.println(((x>m)?n:count[x])+"");
        }

    }


    static class Print {
        private final OutputStream out;

        public Print() {
            this.out = System.out;
        }

        public void print(String str) throws IOException {
            for (int i = 0; i < str.length(); i++) {
                out.write(str.charAt(i));
            }
        }

        public void println(String str) throws IOException {
            print(str);
            out.write('\n');
        }

        public void close() throws IOException {
            out.close();
        }
    }
}
