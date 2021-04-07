package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Asif_the_concourer {
//        public class Main {

    // i am quoting you
    //so suppose a class called 'a' which is  extedning a class called b. now b has a method called arp() that just prints a string.
    // now i dont want to override that function in 'a' but i want to call it inside the class a.
    // so i can do taht with super.
    // but i noticed that i have to call arp() wiht super key from another method in a.
    // but i dont want to create a different method just to call arp. so is there any way around this

    //>>>>>>     Answer >yes you have to call it from other place go to line 35
    //so suppose a class called 'a'
    public static class b {
        int num, count;

        public b(int x, int y) {
            this.num = x;
            this.count = y;
        }

        //now b has a method called arp() that just prints a string
        public void arp() {
            System.out.println(this.num);
            System.out.println(this.count);
        }

        //now i dont want to override that function in 'a' but i want to call it inside the class a
        public void calling_from_a() {
            arp();
        }
    }

    //which is  extedning a class called b
    public class a extends b {

        public a(int x, int y) {
            super(x, y);
        }

        // but i noticed that i have to call arp() wiht super key from another method in a.
        public void call_super(){
            // so i can do taht with super.
            super.arp();
        }

    }

    public static void main(String[] args) throws IOException {
        b B=new b(1,2);
        B.arp();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj).replace("], ", "]\n"));
    }

}