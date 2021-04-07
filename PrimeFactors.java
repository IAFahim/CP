package com.company;
import java.io.*;
import java.util.*;
public class PrimeFactors {
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

    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int i = 1;
        while (true) {
            int x = sc.nextInt();
            if (x == 0) break;
            out.print((x>0)?(x+" = "):(x+" = -1 x "));
            ArrayList list=primeFactors(Math.abs(x));
            for (int j = 0; j < list.size()-1; j++) {
                out.print(list.get(j)+" x ");
            }
            out.println(list.get(list.size()-1));
            i++;
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
