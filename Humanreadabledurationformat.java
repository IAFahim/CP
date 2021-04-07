package com.company;

import java.io.*;
import java.util.*;

public class Humanreadabledurationformat {
    //    public class Main {
    public static String formatDuration(int seconds) {
            String answer = "";
            int found = 0;
            if (found == seconds)
                return "now";
            int year = seconds / (3600 * 24 * 365);
            if (0 < year) {
                seconds -= (year * 3600 * 24* 365);
                found++;
            }
            int day = seconds / (3600 * 24);
            if (0 < day) {
                seconds -= (day * 3600 * 24);
                found++;
            }
            int hour = seconds / 3600;
            if (0 < hour) {
                seconds -= hour * 3600;
                found++;
            }
            int min = seconds / 60;
            if (0 < min) {
                seconds -= min * 60;
                found++;
            }
            int sec = seconds;
            if (0 < seconds) {
                found++;
            }
            while (found-->0){
            if (year > 0) {
                answer += (year + (year==1?" year":" years"));
                year=0;
            }else
            if (day > 0) {
                answer += (day + (day==1?" day":" days"));
                day=0;
            }else
            if (hour > 0) {
                answer += (hour +(hour==1?" hour":" hours"));
                hour=0;
            }else
            if (min > 0) {
                answer += (min + (min==1?" minute":" minutes"));
                min=0;
            }else
            if (0 < sec) {
                answer += (sec + (sec==1?" second":" seconds"));
                sec =0;
            }
            if(found>1){
                answer+=", ";
            }else
                if(found==1){
                    answer+=" and ";
                }
            }
            return answer;
        }

    public static void main(String[] args) throws IOException {
        InputReader sc = new InputReader();//( ╹▽╹ )
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));//start
        out.println(formatDuration(sc.nextInt()));
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
