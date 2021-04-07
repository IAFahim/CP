package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class certifation {
    //    public class Main {
    static void cmdToNameIFkeyword(){
        String cmp = "Art";
        while (true) {
            String str[] = sc.nextLine().split("           ");
            if (str.length == 0) break;
            int at = 0, count = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 8; i < str[1].length(); i++) {
                if (cmp.charAt(at) == str[1].charAt(i)) {
                    at++;
                } else {
                    at = 0;
                }
                if (at == 3) {
                    break;
                }
                sb.append(str[1].charAt(i));
            }
            System.out.println(sb.substring(0, sb.length() - 2).toString() + "");
        }
    }
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int total=sc.nextInt();
        String str = "NSUACMSC-203";
        String INorOUT = "1";
        for (int i = 1; i < total; i++) {
            String s=String.valueOf(i);
            if(s.length()==1){
                System.out.println(str+"00"+s+INorOUT);
            }else if(s.length()==2){
                System.out.println(str+"0"+s+INorOUT);
            }else {
                System.out.println(str+s+INorOUT);
            }
        }
    }

}