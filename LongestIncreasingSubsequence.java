package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class
LongestIncreasingSubsequence {
    //    public class Main {
    static class Card {
        final int i;
        final Card card; // could be null

        Card(int i, Card card) {
            this.i = i;
            this.card = card;
        }

        @Override
        public String toString() {
            return i + "";
        }
    }

    private static int[] retrieveSeq(List<List<Card>> piles) {
        List<Card> rightPile = piles.get(piles.size() - 1);
        Card c = rightPile.get(0);
        int[] seq = new int[piles.size()];
        int k = seq.length - 1;

        while (c != null) {
            seq[k--] = c.i;
            c = c.card;
        }

        return seq;
    }

    static int binarySearchHostPileIdx(List<List<Card>> piles, int i) {
        int l = 0; // left
        int r = piles.size() - 1; // right
        int m = -1; // middle

        if (piles.isEmpty()) return -1;

        while (l <= r) {
            /*
             * Pick the middle. Same as (l + r) / 2 but does not run the risk of integer overflow
             */
            m = l + (r - l) / 2;

            List<Card> pile = piles.get(m);
            Card c = pile.get(pile.size() - 1); // get the top card from this pile

            if (c.i == i) return m; // exact match

            if (c.i < i) {
                l = m + 1; // ignore left half
            } else {
                r = m - 1; // ignore right half
            }
        }

        if (l >= piles.size()) return -1;

        List<Card> lPile = piles.get(l);
        return lPile.get(lPile.size() - 1).i >= i ? l : -1;
    }

    public static int[] run(int[] ar) {

        List<List<Card>> piles = new ArrayList<>();

        /**
         * "patience sort" each value into piles
         */
        for (int k = 0; k < ar.length; k++) {
            int hostPileIdx = binarySearchHostPileIdx(piles, ar[k]);

            List<Card> hostPile;
            if (hostPileIdx < 0) { // start a new pile
                hostPile = new ArrayList<>();
                piles.add(hostPile);
                hostPileIdx = piles.size() - 1;
            } else {
                hostPile = piles.get(hostPileIdx); // found a host
            }

            Card leftCard = null;
            if (hostPileIdx > 0) {
                // except for left most pile, link the card to the top card of the pile immediately on the left
                List<Card> leftPile = piles.get(hostPileIdx - 1);
                leftCard = leftPile.get(leftPile.size() - 1); // top most card of the pile immediately on the left
            }

            hostPile.add(new Card(ar[k], leftCard));
        }

        return retrieveSeq(piles);
    }

    public static void main(String[] args) throws IOException {
        int arr[]=new int[]{2,4,5,6,6,10,3,12};
        int brr[]=run(arr);
        debug(brr);

        close.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj).replace("], ", "]\n"));
    }

    static class Sc {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Sc() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Sc(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
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

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
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

    static Sc sc = new Sc();
    static Print out = new Print();
    static BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
}