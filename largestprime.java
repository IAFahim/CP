//package com.company;
import java.io.*;
import java.util.*;
public class largestprime {
//public class Main {
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
    // n is a prime number greater than 2`
    if (n > 2)
        prime_factor_int.add(n);
    return prime_factor_int;
}
public static void main(String[] args) throws IOException {
    out = new PrintWriter(new BufferedOutputStream(System.out));
    MyScanner sc = new MyScanner();//start
    long x;
    while(true){
        x=Math.abs(sc.nextLong());
        if(x==0)
            break;
        if(x==1){
            out.println(-1);
            break;
        }
        ArrayList<Long> pp=primeFactors(x);
        out.println((pp.get(pp.size()-1)==x)?-1:pp.get(pp.size()-1));
        //x=sc.nextLong();
        //out.println(primeFactors(x));
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
