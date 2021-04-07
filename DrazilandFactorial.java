//package com.company;

import java.io.*;
import java.util.*;

public class DrazilandFactorial {
//        public class Main {
    public static void main(String[] args) throws IOException {
        //Caution:
        //took help from https://www.youtube.com/watch?v=QEh0ugyYPUw
        Sc sc = new Sc();
        Print out = new Print();
        BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Character, String> map = new HashMap<>();
        map.put('0', "");
        map.put('1', "");
        map.put('2', "2");
        map.put('3', "3");
        map.put('4', "223");
        map.put('5', "5");
        map.put('6', "35");
        map.put('7', "7");
        map.put('8', "2227");
        map.put('9', "2337");
        int till = sc.nextInt();
        String str = sc.nextString();
        String answer = "";
        for (int z = 0; z < till; z++) {
            answer += map.get(str.charAt(z));
        }
        Character[] characters=new Character[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            characters[i]=answer.charAt(i);
        }
        Arrays.sort(characters,Collections.reverseOrder());
        StringBuilder st=new StringBuilder();
        for (int i = 0; i < characters.length; i++) {
            st.append(characters[i]);
        }
        out.println(st.toString());
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