//package com.company;

import java.io.*;
import java.util.*;

public class SetRelation {
//        public class Main {
    static String set[][];
    static TreeSet<String> uniqe;
    static boolean ReflexiveRelation;
    static boolean Symmetric_Relation;
    static boolean TransitiveRelation;
    static boolean EquivalenceRelation;


    static boolean is_ReflexiveRelation() {
        int found = 0;
        for (int i = 0; i < set.length; i++) {
            if (set[i][0].equals(set[i][1])) {
                found++;
            }
        }
        return (found == uniqe.size());
    }

    static boolean is_Symmetric_Relation() {
        int found = 0;
        for (int i = 0; i < set.length; i++) {
            for (int j = 0; j < set.length; j++) {
                if (set[i][0].equals(set[j][1]) && set[i][1].equals(set[j][0])) {
                    found++;
                    break;
                }
            }
            if (found == 1) {
                found = 0;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean is_TransitiveRelation() {
        int found = 0;
        for (int i = 0; i < set.length; i++) {
            for (int j = 0; j < set.length; j++) {
                if (set[i][1].equals(set[j][0])) {
                    found++;
                    break;
                }
            }
            if (found == 1) {
                found = 0;
            } else {
                return false;
            }

        }
        return true && ReflexiveRelation;
    }

    public static boolean is_EquivalenceRelation() {
        return ReflexiveRelation && Symmetric_Relation && TransitiveRelation;
    }

    static void printMatrix(int[][] adj, int V) throws Exception {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                out.print(adj[i][j] + " ");
            }
            out.println("");
        }
        out.println("");
    }
    static int mat[][];
    static ArrayList<String> all;
    static void convert(){
        all=new ArrayList<>();
        all.addAll(uniqe);
        mat= new int[uniqe.size()][uniqe.size()];
        int at=0;
        for (int i = 0; i < set.length; i++) {
            mat[uniqe.headSet(set[i][0]).size()][uniqe.headSet(set[i][1]).size()]++;
        }
    }
    static void print() throws Exception{
        out.print("\t");
        for (int i = 0; i < uniqe.size(); i++) {
            out.print("\t"+all.get(i));
        }
        out.println("");
        for (int i = 0; i < mat.length; i++) {
            out.print("\t"+all.get(i));
            for (int j = 0; j < mat[0].length; j++) {
                out.print("\t"+mat[i][j]);
            }
            out.println("");
        }
    }

    static Scanner sc = new Scanner(System.in);
    static Print out = new Print();
    static BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        String str = sc.nextLine(),store=sc.nextLine();
        while (!store.equals("")){
            str+=store;
            store=sc.nextLine();
        }
        ArrayList<String> list = new ArrayList<>();
        uniqe = new TreeSet<>();
        int found = 0;
        boolean brackeet = false;
        StringBuilder currentNumber = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{') {
                brackeet = !brackeet;
            }
            if (brackeet)
                if (('0' <= str.charAt(i) && str.charAt(i) <= '9') || ('a' <= str.charAt(i) && str.charAt(i) <= 'z') || ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')) {
                    currentNumber.append(str.charAt(i));
                } else if (str.charAt(i) == ',') {
                    list.add(currentNumber.toString());
                    currentNumber.setLength(0);
                    found++;
                } else if (str.charAt(i) == '}') {
                    list.add(currentNumber.toString());
                    currentNumber.setLength(0);
                    found++;
                    break;
                }
        }
        uniqe.addAll(list);
        set = new String[found / 2][2];
        for (int i = 0, j = 0; i < found / 2; i++) {
            set[i][0] = list.get(j++);
            set[i][1] = list.get(j++);
        }

        ReflexiveRelation = is_ReflexiveRelation();
        Symmetric_Relation = is_Symmetric_Relation();
        TransitiveRelation = is_TransitiveRelation();
        EquivalenceRelation = is_EquivalenceRelation();

        out.println(ReflexiveRelation ? "Reflexive Relation" : "Irreflexive Relation");
        out.println(Symmetric_Relation ? "Symmetric Relation" : "Anti-symmetric Relation");
        out.println(TransitiveRelation ? "Transitive Relation" : "Not Transitive Relation");
        out.println(EquivalenceRelation ? "Equivalence Relation" : "Not Equivalence Relation");
        out.print("Adjacency Matrix: \n");
        convert();
        print();
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