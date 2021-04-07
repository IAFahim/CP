package com.company;

import java.io.*;
import java.util.*;

public class MatrixDeterminant {
    //    public class Main {
    public static int determinant(int[][] matrix) {
        // Your code here!
        int startColumn = 0;
        for (int row=0; row<matrix.length; row++) {
            //if the number in the start column is 0, try to switch with another
            while (matrix[row][startColumn]==0.0){
                boolean switched = false;
                int i=row;
                while (!switched && i<matrix.length) {
                    if(matrix[i][startColumn]!=0.0){
                        int[] temp = matrix[i];
                        matrix[i]=matrix[row];
                        matrix[row]=temp;
                        switched = true;
                    }
                    i++;
                }
                //if after trying to switch, it is still 0, increase column
                if (matrix[row][startColumn]==0.0) {
                    startColumn++;
                }
            }
            //if the number isn't one, reduce to one
            if(matrix[row][startColumn]!=1.0) {
                int divisor = matrix[row][startColumn];
                for (int i=startColumn; i<matrix[row].length; i++) {
                    matrix[row][i] = matrix[row][i]/divisor;
                }
            }
            //make sure the number in the start column of all other rows is 0
            for (int i=0; i<matrix.length; i++) {
                if (i!=row && matrix[i][startColumn]!=0) {
                    double multiple = 0-matrix[i][startColumn];
                    for (int j=startColumn; j<matrix[row].length; j++){
                        matrix[i][j] +=
                                multiple*matrix[row][j];
                    }
                }
            }
            startColumn++;
        }
        return 0;
    }
    
    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][][] matrix = { {{1}},
                {{1, 3}, {2,5}},
                {{2,5,3}, {1,-2,-1}, {1, 3, 4}}};
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