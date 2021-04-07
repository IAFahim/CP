//package com.company;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class Factovisors {
//    public class Main {
        public static ArrayList<Long> primeFactors(long n) {
            ArrayList<Long> prime_factor_int = new ArrayList<Long>();
            // Print the number of 2s that divide n
            while (n % 2 == 0) {
                prime_factor_int.add(2L);
                n /= 2;
            }

            // n must be odd at this point.  So we can
            // skip one element (Note i = i +2)
            for (long i = 3; i <= Math.sqrt(n); i += 2) {
                // While i divides n, print i and divide n
                while (n % i == 0) {
                    prime_factor_int.add(i);
                    n /= i;
                }
            }

            // This condition is to handle the case whien
            // n is a prime number greater than 2
            if (n > 2)
                prime_factor_int.add(n);
            return prime_factor_int;
        }

    static long getCount(long n, long p) { // occurrences of P in n!
        long cnt = 0;
        for(long i = p; i <= n; i *= p) {
            cnt += (n / i);
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
//        int k=5;
//        while (k-->0){
        while (sc.br.ready()){
        long a=sc.nextLong();
        long x=sc.nextLong();
        out.println(get_powers(a,x));
            if(a>=x || a==0){
            out.println(x+" does not divide "+a+"!");
            continue;
        }
        if(a<1){
            out.println(x+" does not divide "+a+"!");
            continue;
        }
        if(a==1){
            out.println(x+" divides "+a+"!");
            continue;
        }
        if(x==1){
            out.println(x+" divides "+a+"!");
            continue;
        }
        ArrayList<Long> primes = primeFactors(x);
        int size = 1;
        boolean cond=true;
        long last = primes.get(0);
        for (int i = 1; i < primes.size(); i++) {
            if (primes.get(i) == last) size++;
            else {

                if(!(get_powers(a,primes.get(i))>=size)){
                    out.println(x+" does not divide "+a+"!");
                    cond=false;
                    break;
                }
                last = primes.get(i);
                size = 1;
            }
        }
        if(!((get_powers(a,last))>=size)&&cond)
        out.println(x+" does not divide "+a+"!");
        else if(cond)
        out.println(x+" divides "+a+"!");
        }
        out.close();
    }
    static long get_powers(long n, long p)
    {
        long res = 0;
        for (long power = p ; power <= n ; power *= p)
            res += n/power;
        return res;
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
