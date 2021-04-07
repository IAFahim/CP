//package com.company;

import java.io.*;
import java.util.*;

public class Thelastdigit {
//        public class Main {
    public static int pow(int a, int b){
        if(b==0) return 1;
        int ret = pow(a,b/2);
        ret *= ret;
        if(b%2==1) ret *= a;
        return ret%10;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int till=sc.nextInt();
        for (int i = 1; i <= till; i++) {
            int a=sc.nextInt(),b=sc.nextInt();
            System.out.println(pow(a%10,b));
        }
    }
}