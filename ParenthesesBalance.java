package com.company;

import java.io.*;
import java.util.*;

public class ParenthesesBalance {
//    public class Main {
    public static boolean bracket_pew_pew(String text) {
        Stack<Character> stack = new Stack<Character>();
        for (int j = 0; j < text.length(); j++) {
            if (text.charAt(j) == '(' || text.charAt(j) == '[' || text.charAt(j)=='{') {
                stack.push(text.charAt(j));
                continue;
            }
            if(stack.empty())return false;
            else if (text.charAt(j) == ')' && stack.pop() != '(') return false;
            else if (text.charAt(j) == '}' && stack.pop() != '{') return false;
            else if (text.charAt(j) == ']' && stack.pop() != '[') return false;
        }
        return stack.empty();
    }

    public static void main(String[] args) {

        out = new PrintWriter(new BufferedOutputStream(System.out));
        MyScanner sc = new MyScanner();//start
        int till = sc.nextInt();
        for (int i = 1; i <= till; i++) {
            String text = sc.nextLine();
            out.println(bracket_pew_pew(text)?"Yes":"No");
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
