//package com.company;

import java.io.*;
import java.util.*;

public class matrixLib {
    //    public class Main {

    static ArrayList<double[][]> mat = new ArrayList<double[][]>();
    static int matixCount = 0;
    static ArrayList<Double> all = new ArrayList<>();
    static int X = 0, Y = 0, fill = 0;
    static int size[][];

    static void add_matix(String str) {
        X = 0;
        Y++;
        for (int k = 0, fill = 0; k < str.length(); k++) {
            String num = "";
            while (k < str.length() && '-' <= str.charAt(k) && str.charAt(k) <= '9') {
                num += str.charAt(k) + "";
                k++;
            }
            X++;
            if (num.contains("/")) {
                String split[] = num.split("/");
                num = "" + (Double.parseDouble(split[0]) / Double.parseDouble(split[1]));
            }
            all.add(Double.parseDouble(num));
        }
        while (X < fill) {
            all.add((double) 0);
            X++;
        }
        fill = X;
    }

    static void construct() {
        double mata[][] = new double[Y][X];
        for (int i = 0, k = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                mata[i][j] = all.get(k++);
            }
        }
        size = new int[][]{{matixCount}, {X, Y}};
        X = 0;
        Y = 0;
        fill = 0;
        all.clear();
        matixCount++;
        mat.add(mata);
        a = mata;
    }

    static String format(double x) {
        if (x - (int) x == 0)
            return (int) x + "";
        return decimalToFraction(x);
    }

    static Scanner sc = new Scanner(System.in);
    static BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
    static Print out = new Print();

    static double a[][];
    static ArrayList<String> notes = new ArrayList<>();

    static int PerformOperation() throws IOException {
        int i, j, k = 0, c, flag = 0, m = 0, n = a.length;
        double pro = 0;
        for (i = 0; i < n; i++) {
            if (a[i][i] == 0) {
                c = 1;
                while ((i + c) < n && a[i + c][i] == 0)
                    c++;
                if ((i + c) == n) {
                    flag = 1;
                    break;
                }
                for (j = i, k = 0; k < n; k++) {
                    double temp = a[j][k];
                    a[j][k] = a[j + c][k];
                    a[j + c][k] = temp;
                }
                notes.add("" + j + " [NOTE ><]Swaped r" + (j + 1) + " -> r" + (j + c + 1) + " & " + "r" + (j +c+1) + " -> r" + (j + 1) + " ;");
                printMatrixCOn();
            }
            for (j = 0; j < n; j++) {

                if (i != j) {
                    double p = a[j][i] / a[i][i];

                    for (k = 0; k < n && j < n; k++)
                        a[j][k] = a[j][k] - (a[i][k]) * p;
                    notes.add(j + " [NOTE: ] r" + (j + 1) + "= r" + (j + 1) + "\' " + (0 < p ? "+ (" : "- (") + format(Math.abs(p)) + " * r" + (i + 1) + ") ;");
                    printMatrixCOn();
                }
            }
        }
        return flag;
    }

    static int CheckConsistency(int flag) throws IOException {
        int i, j, n = a.length;
        double sum;
        flag = 3;
        for (i = 0; i < n; i++) {
            sum = 0;
            for (j = 0; j < n; j++)
                sum = sum + a[i][j];
            if (sum == a[i][j])
                flag = 2;
        }
        return flag;
    }

    static double temp[][];

    static void rowReduction() throws IOException {
        int flag = 0;
        temp = a;
        printMatrixCOn();
        flag = PerformOperation();
        printMatrixCOn();
        if (flag == 1)
            flag = CheckConsistency(flag);
    }

    static void printMatrixCOn() throws IOException {
        for (int i = 0; i < a.length; i++) {
            if (!Arrays.equals(a[i], temp[i])) {
                return;
            }
        }

        out.println("=");
        for (int j = 0; j < a.length; j++) {
            out.print("\t");
            for (int k = 0; k < a[0].length; k++) {
                out.print(format(a[j][k]) + "\t");
            }
            for (int i = 0; i < notes.size(); i++) {
                if (notes.get(i).charAt(0) - '0' == j) {
                    out.print(notes.get(i).substring(1));
                    notes.remove(i);
                }
            }
            out.println("");
        }
        temp = a;
    }

    static void printMatrix(int i) throws IOException {
        boolean done = false;
        if (i == 4) {
            i = 0;
        } else {
            done = true;
        }
        for (; i < mat.size(); i++) {
            out.println(Character.toString('A' + i) + "=");
            double mata[][] = mat.get(i);
            for (int j = 0; j < mata.length; j++) {
                out.print("\t");
                for (int k = 0; k < mata[0].length; k++) {
                    out.print(format(mata[j][k]) + "\t");
                }
                out.println("");
            }
            if (done) break;
        }

    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    static String decimalToFraction(double number) {

        double intVal = Math.floor(number);

        double fVal = number - intVal;

        final long pVal = 1000000000;

        long gcdVal = gcd(Math.round(
                fVal * pVal), pVal);

        long num = Math.round(fVal * pVal) / gcdVal;
        long deno = pVal / gcdVal;
        String str = ((long) (intVal * deno) + num + "/" + deno);
        return (str.length() < 6) ? str : ((double) Math.round(number * 100000d) / 100000d) + "";
    }

    public static void main(String[] args) throws IOException {
        Boolean done = false;
        for (int j = 0; !done; j++) {
            String str = sc.nextLine();
            switch (str) {
                case "p":
                    if (0 < mat.size())
                        printMatrix(4);
                    else out.println("\t0 matirx found");
                    break;
                case "e":
                    done = true;
                    break;
                case "":
                    if (0 < Y) {
                        construct();
                        rowReduction();
                    }
                    break;
                default:
                    if ('-' <= str.charAt(0) && str.charAt(0) <= '9')
                        add_matix(str);
                    break;
            }
        }
        close.close();
    }

    static class Sc {
        private byte[] buf = new byte[1024];
        private int index;
        private InputStream in;
        private int total;

        public Sc() {
            in = System.in;
        }

        public int read() throws IOException {
            if (total < 0)
                throw new InputMismatchException();
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0)
                    return -1;
            }
            return buf[index++];
        }

        public int nextInt() throws IOException {
            int integer = 0;
            int n = read();
            while (isWhiteSpace(n))
                n = read();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = read();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = read();
                } else throw new InputMismatchException();
            }
            return neg * integer;
        }

        public double nextDouble() throws IOException {
            double doub = 0;
            int n = read();
            while (isWhiteSpace(n))
                n = read();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = read();
            }
            while (!isWhiteSpace(n) && n != '.') {
                if (n >= '0' && n <= '9') {
                    doub *= 10;
                    doub += n - '0';
                    n = read();
                } else throw new InputMismatchException();
            }
            if (n == '.') {
                n = read();
                double temp = 1;
                while (!isWhiteSpace(n)) {
                    if (n >= '0' && n <= '9') {
                        temp /= 10;
                        doub += (n - '0') * temp;
                        n = read();
                    } else throw new InputMismatchException();
                }
            }
            return doub * neg;
        }

        public String nextString() throws IOException {
            StringBuilder sb = new StringBuilder();
            int n = read();
            while (isWhiteSpace(n))
                n = read();
            while (!isWhiteSpace(n)) {
                sb.append((char) n);
                n = read();
            }
            return sb.toString();
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
                return true;
            return false;
        }
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