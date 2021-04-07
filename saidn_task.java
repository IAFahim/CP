//package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class saidn_task {
//public class Main {

    public static class Pair {
        double total, average;

        public Pair(double x, double y) {
            this.total = x;
            this.average = y;
        }
    }

    public static Pair total_average(double student_number[][]) {
        Pair answer = new Pair(0, 0);
        for (int y = 0; y < student_number.length; y++) {
            for (int x = 0; x < student_number[y].length; x++) {
                answer.total += student_number[y][x];
            }
            answer.average = answer.total / (double) (student_number[y].length * student_number.length);
        }
        return answer;
    }

    public static double total(double arr[]) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        int X = 4, Y = 4;
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        Y = sc.nextInt();
        double student_number[][] = new double[Y][X];
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                student_number[y][x] = sc.nextDouble();
            }
            double sum = total(student_number[y]);
            System.out.println(sum);
        }
        Pair answer = total_average(student_number);
        System.out.println(answer.total);
        System.out.println(answer.average);
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj).replace("], ", "]\n"));
    }

}