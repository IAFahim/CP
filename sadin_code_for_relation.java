//package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class sadin_code_for_relation {
    //    public class Main {

    public static int friend_count_like_i_had_any(boolean arr[][]) {
        int count = 0;
        for (int y = 0; y < arr.length; y++) {
            for (int x = y; x < arr[y].length; x++) {
                if (arr[y][x] && arr[x][y]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean arr[][] = new boolean[5][5];
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr.length; x++) {
                arr[y][x] = sc.nextBoolean();
            }
        }
        System.out.print("#");
        for (int x = 0; x < arr.length; x++) {
            System.out.print("\t" + x);
        }
        System.out.println();
        for (int y = 0; y < arr.length; y++) {
            System.out.print(y);
            for (int x = 0; x < arr.length; x++) {
                if (arr[y][x]) {
                    System.out.print("\t*");
                } else {
                    System.out.print("\t ");
                }
            }
            System.out.println();
        }
        int count= friend_count_like_i_had_any(arr);
        System.out.println("Friends count: "+count);
    }
}