//package com.company;

import java.io.*;
import java.util.*;

public class StreetFighter2CharacterSelection {
    //    public class Main {
    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
        String answer[] = new String[moves.length];
        for (int i = 0; i < moves.length; i++) {
            if (moves[i].equals("up")) {
                if (position[0] != 0) position[0]--;
            } else if (moves[i].equals("down")) {
                if (fighters.length-1 != position[0]) position[0]++;
            } else if (moves[i].equals("right")) {
                if(position[1] ==fighters[0].length-1)
                    position[1]=0;
                else position[1]++;
            } else {
                if(position[1]==0)
                    position[1]=fighters[0].length-1;
                else position[1]--;
            }
            answer[i] = fighters[position[0]][position[1]];
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        String[][] fighters = new String[][]{
                new String[]{"Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"},
                new String[]{"Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"},
        };
        String[] moves = new String[] { "up", "left", "down", "right", "up", "left", "down", "right" };
        String[] solution = new String[] { "Ryu", "Vega", "M.Bison", "Ken", "Ryu", "Vega", "M.Bison", "Ken" };
        streetFighterSelection(fighters, new int[]{0, 0}, moves);
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