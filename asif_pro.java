package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class asif_pro {
//        public class Main {

    public static void main(String[] args) throws IOException {
        Input input = new Input();
//        input.str = "3 5 2 4";
//        input.process();
//        input.str = "a 2 10/5";
//        input.process();
//        input.str = "b 16 5";
//        input.process();
//        input.str = "a";
//        input.process();
//        input.str = "b";
//        input.process();
        input.str = "c 5 5";
//        input.process();
//        input.str = "c";
        input.process();
        input.str = "..";
        input.process();

        close.close();
    }

    static class Pair {
        double x, y;

        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    enum TypeOfString {
        empty, unknown, number, plotFromTo, lowercase, uppercase, graphCordinese,
    }

    public enum Thislineis {
        addACordinate, drawLineBetweenTwoPoints, singleValuePrintCordinates, allValuesPrint, graphCordinese, graphEverything
    }

    public static class Input {
        Thislineis thislineis;
        String str;
        private int length = 0;
        Map<Character, Pair> cordinates;

        int grahSizeY = Integer.MAX_VALUE;
        int grahSizeX = Integer.MAX_VALUE;
        int grahSizeDecimalInceaseNeeded = 0;
        Graph graph = new Graph();
        Pair maxInCordinates = new Pair(0, 0);
        Pair minInCordinates = new Pair(grahSizeX, grahSizeX);
        Text text = new Text();

        public void process() throws IOException {
            String arr[] = str.split(" ");
            TypeOfString stringIs[] = new TypeOfString[arr.length];
            int number_count = 0;
            int singleLowerAphabet_count = 0;
            //lower at 0
            for (int i = 0; i < arr.length; i++) {
                stringIs[i] = typeFinder(arr[i]);
                if (stringIs[i] == TypeOfString.number) {
                    number_count++;
                } else if (stringIs[i] == TypeOfString.lowercase) {
                    singleLowerAphabet_count++;
                }
            }

            if (stringIs[0] == TypeOfString.lowercase && number_count == 2) {
                length++;
                if (length == 1) {
                    this.cordinates = new HashMap<>();
                }
                push_to_cordinates(arr[0], arr[1], arr[2]);
                thislineis = Thislineis.addACordinate;
            } else if (stringIs[0] == TypeOfString.lowercase && singleLowerAphabet_count == 1) {
                thislineis = Thislineis.singleValuePrintCordinates;
                text.print_text();
            } else if (stringIs[0] == TypeOfString.lowercase && stringIs[2] == TypeOfString.lowercase) {
                thislineis = Thislineis.drawLineBetweenTwoPoints;
            } else if (stringIs[0] == TypeOfString.graphCordinese) {
                thislineis = Thislineis.graphCordinese;
                char separator = ' ';
                if (1 < arr[0].length()) {
                    separator = arr[0].charAt(1);
                }
                graph.cordinatePrint(separator);
            }

        }

        public class Text {
            public String toString3dec(double x) {
                long i = (long) x;
                if (x - i < EPS) {
                    return Long.toString(i);
                }
                return String.format("%.3f", x);
            }

            public void print_text() throws IOException {
                if (thislineis == Thislineis.singleValuePrintCordinates) {
                    if (cordinates.containsKey(str.charAt(0))) {
                        Pair point = cordinates.get(str.charAt(0));
                        out.println(str.charAt(0) + " " + toString3dec(point.x) + " " + toString3dec(point.y));
                    } else {
                        out.println(str.charAt(0) + " is Undefined");
                    }
                }
            }

            public void java_code_output() throws IOException {
                if (thislineis == Thislineis.singleValuePrintCordinates) {
                    Pair point = cordinates.get(str.charAt(0));
                    out.println("double " + str.charAt(0) + "[]= {" + point.x + ", " + point.y + "};");
                }
            }
        }

        double EPS = 1.0E-6;

        private void push_to_cordinates(String varibaleName, String x, String y) {
            Pair temporary = new Pair(d(x), d(y));
            if (maxInCordinates.x < temporary.x) {
                maxInCordinates.x = temporary.x;
            } else {
                minInCordinates.x = temporary.x;
            }
            if (maxInCordinates.y < temporary.y) {
                maxInCordinates.y = temporary.y;
            } else {
                minInCordinates.y = temporary.y;
            }
            double totalAdd=temporary.x+temporary.y;
            grahSizeDecimalInceaseNeeded=abs((int)((totalAdd-(int)(totalAdd))*100)/20);
            this.cordinates.put(varibaleName.charAt(0), new Pair(d(x), d(y)));
        }

        public double d(String str) {
            String arr[] = str.split("/");
            double x = Double.parseDouble(arr[0]);
            if (arr.length == 2) {
                double sec = Double.parseDouble(arr[1]);
                if (sec - EPS < 0) {
                    return 999999999.999;
                }
                x /= sec;
            }
            return x;
        }


        /*
           finds type of every kind string, number, others, ai mode soon
        */

        public TypeOfString typeFinder(String st) {

            if (st.length() <= 1 && 'a' <= st.charAt(0) && st.charAt(0) <= 'z') {
                return TypeOfString.lowercase;
            } else if (st.length() <= 1 && 'A' <= st.charAt(0) && st.charAt(0) <= 'Z') {
                return TypeOfString.uppercase;
            } else if (st.length()==0) {
                return TypeOfString.graphCordinese;
            } else {
                int i = 0;
                if (st.charAt(0) == '-') {
                    if (st.length() == 1) {
                        return TypeOfString.plotFromTo;
                    }
                }
                i = 1;
                boolean flaw = false;
                for (; i < st.length(); i++) {
                    char c = st.charAt(i);
                    if (c < '-' || c > '9') {
                        flaw = true;
                        break;
                    }
                }
                if (!flaw)
                    return TypeOfString.number;
            }
            return TypeOfString.unknown;
        }

        /*
            Graph class
        */
        enum TypeOfGraph {
            single, Quad
        }

        public class Graph {
            char[][] graph_bitmap;
            int midHorzian_x = 0;
            int midVartcal_y = 0;
            TypeOfGraph typeOfGraph = TypeOfGraph.single;
            int points = 0;

            public void quadBowlerPlate() {
                graph_bitmap = new char[129][129];
                midHorzian_x = graph_bitmap.length / 2;
                midVartcal_y = graph_bitmap[0].length / 2;

                for (int i = 0; i < graph_bitmap.length; i++) {
                    for (int j = 0; j < graph_bitmap[i].length; j++) {
                        if (j == midVartcal_y) {
                            graph_bitmap[i][j] = '|';
                        } else if (i == midHorzian_x) {
                            graph_bitmap[i][j] = '-';
                        } else {
                            graph_bitmap[i][j] = ' ';
                        }
                    }
                }
                graph_bitmap[midHorzian_x][midVartcal_y] = '+';
            }

            /*
                points are made with there value it can hadle graph with 0.2 decinal point and makes a need graph
            */
            public void singleBowlerPlate(char separator) {
                int y=((int) maxInCordinates.y + 1);
                int x=((int) maxInCordinates.x + 1);
                if(grahSizeDecimalInceaseNeeded!=0){
                    y*=grahSizeDecimalInceaseNeeded;
                    x*=grahSizeDecimalInceaseNeeded;
                }
                graph_bitmap = new char[y][x+1];
                for (int i = 0; i < graph_bitmap.length; i++) {
                    graph_bitmap[i][0] = '>';
                }
                for (int i = 0; i < graph_bitmap.length - 1; i++) {
                    for (int j = 1; j < graph_bitmap[i].length; j++) {
                        graph_bitmap[i][j] = separator;
                    }
                }
                int j = graph_bitmap.length;
                for (j = 1; j < graph_bitmap[0].length; j++) {

                    graph_bitmap[graph_bitmap.length - 1][j] = separator;
                }
                graph_bitmap[graph_bitmap.length - 1][0] = '0';
            }

            public void update(double X, double Y, char ch) {
                int x = (int) X, y = (int) Y;
                if (typeOfGraph == TypeOfGraph.single && 0 <= x && 0 <= y && x < graph_bitmap[y].length && y < graph_bitmap.length) {
                    graph_bitmap[y][x] = ch;
                    points++;
                }
            }

            public void cordinatePrint(char seprator) throws IOException {
                if (0 <= minInCordinates.x && 0 <= maxInCordinates.y) {
                    typeOfGraph = TypeOfGraph.single;
                    singleBowlerPlate(seprator);
                } else {
                    typeOfGraph = TypeOfGraph.Quad;
                    quadBowlerPlate();
                    //quad
                }
                for (char c : cordinates.keySet()) {
                    double x = cordinates.get(c).x;
                    double y = maxInCordinates.y - cordinates.get(c).y;
                    update(x, y, c);
                }
                print();
            }

            public void print() throws IOException {
                for (int y = 0; y < graph_bitmap.length; y++) {
                    for (int x = 0; x < graph_bitmap[y].length; x++) {
                        out.print(graph_bitmap[y][x] + "");
                    }
                    out.println("");
                }
            }
        }

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