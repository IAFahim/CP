//package com.company;

import java.io.*;
import java.security.GuardedObject;
import java.util.*;

public class jordarn {
    //    public class Main {
    public static class GaussJordan{
    private double[][] augmentedMatrix;

        /**
         * Constructor for a GaussJordan object. Takes in a two dimensional double
         * array holding the matrix.
         *
         * @param matrix A double[][] containing the augmented matrix
         */
        public GaussJordan(double[][] matrix) {
            augmentedMatrix = matrix;
        }

        /**
         * Runs a Gauss-Jordan elimination on the augmented matrix in order to put
         * it into reduced row echelon form
         *
         */
        public void eliminate() {
            int startColumn = 0;
            for (int row=0; row<augmentedMatrix.length; row++) {
                //if the number in the start column is 0, try to switch with another
                while (augmentedMatrix[row][startColumn]==0.0){
                    boolean switched = false;
                    int i=row;
                    while (!switched && i<augmentedMatrix.length) {
                        if(augmentedMatrix[i][startColumn]!=0.0){
                            double[] temp = augmentedMatrix[i];
                            augmentedMatrix[i]=augmentedMatrix[row];
                            augmentedMatrix[row]=temp;
                            switched = true;
                        }
                        i++;
                    }
                    //if after trying to switch, it is still 0, increase column
                    if (augmentedMatrix[row][startColumn]==0.0) {
                        startColumn++;
                    }
                }
                //if the number isn't one, reduce to one
                if(augmentedMatrix[row][startColumn]!=1.0) {
                    double divisor = augmentedMatrix[row][startColumn];
                    for (int i=startColumn; i<augmentedMatrix[row].length; i++) {
                        augmentedMatrix[row][i] = augmentedMatrix[row][i]/divisor;
                    }
                }
                //make sure the number in the start column of all other rows is 0
                for (int i=0; i<augmentedMatrix.length; i++) {
                    if (i!=row && augmentedMatrix[i][startColumn]!=0) {
                        double multiple = 0-augmentedMatrix[i][startColumn];
                        for (int j=startColumn; j<augmentedMatrix[row].length; j++){
                            augmentedMatrix[i][j] +=
                                    multiple*augmentedMatrix[row][j];
                        }
                    }
                }
                startColumn++;
            }
        }

        /**
         * Returns a String with the contents of the augmented matrix.
         *
         * @return A String representation of the augmented matrix
         */
        public String toString() {
            String text = "";
            for (int i=0; i<augmentedMatrix.length; i++) {
                for (int j=0; j<augmentedMatrix[i].length; j++) {
                    text+=augmentedMatrix[i][j] + ", ";
                }
                text+="\n";
            }
            return text;
        }
    }
    public static void main(String[] args) throws IOException {
        InputReader sc = new InputReader();//( ╹▽╹ )
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));//start
        double[][] array1 = {
                {1,5,1,2,0},
                {2,0,2,4,1},
                {0,1,0,0,1},
                {0,0,1,1,2}
        };
        GaussJordan example = new GaussJordan(array1);
        example.eliminate();
        System.out.println(example);

        out.close();
    }


    //-----------PrintWriter for faster output---------------------------------
    static class InputReader {
        private byte[] buf = new byte[16384];
        private int curChar;
        private int numChars;

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = System.in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
//--------------------------------------------------------

}
