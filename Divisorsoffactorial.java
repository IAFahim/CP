package com.company;

import java.io.*;
import java.util.*;

public class Divisorsoffactorial {
//    public class Main {
    static int n=1000000;
    static boolean prime[] = new boolean[n+1];
    public static void sieveOfEratosthenes() {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        for (int i = 0; i < n; i++)
            prime[i] = true;


        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p]) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
    }
    public static void main(String[] args) {
//        limit=10000
//        prime = [True] * limit
//        def prime_sieve():
//        prime[0] = prime[1] = False
//        for i, is_prime in enumerate(prime):
//        if is_prime:
//        yield i
//        for n in range(i * i, limit, i):
//        prime[n] = False
//        new=list(prime_sieve())
//        x=int(input())
//        mod=10**9+7
//        for _ in range(x):
//        n=int(input())
//        total=1
//        for i in new:
//        if(i>n):
//        break
//                temp=n
//                count=0
//        while(temp>0):
//        count+=temp//i
//        temp//=i
//                total=((total%mod)*(count+1%mod))%mod
//        print(total)
        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till=sc.nextInt();
        int mod=1000000007;
        sieveOfEratosthenes();
        for (int z = 0; z < till; z++) {
            long x=sc.nextLong(),total=1;
            for (int i = 2; i < n; i++) {
                if(i>x)break;
                long temp= x,count=0;
                while(temp>0){
                    if(prime[i]){
                        count+=temp/i;
                        temp/=i;
                    }else {
                        i++;
                    }
                }
                    total=(((count+1)%mod)*(total%mod))%mod;
            }
            out.println(total);
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
