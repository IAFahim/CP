//package com.company;

import java.io.*;
import java.util.*;

public class BrokenKeyboard {
//        public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while (sc.hasNext()){
            str=sc.nextLine();
            LinkedList<Character> list=new LinkedList<>();
            int start=0;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)=='[')
                    start=0;
                else
                    if(str.charAt(i)==']')
                        start=list.size();
                    else
                        list.add(start++,str.charAt(i));
            }StringBuilder stringBuilder=new StringBuilder();
            for (char c: list) {
                stringBuilder.append(c);
            }
            out.println(stringBuilder.toString());
        }
        close.close();
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