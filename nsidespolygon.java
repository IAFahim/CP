package com.company;

import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

import static java.lang.Math.*;

public class nsidespolygon {
    //    public class Main {
    static class Geomatry {

        public static double areaOfPolygonInsideCircle(double r, int n) {
            return round(500 * r * r * n * sin((2 * PI) / n)) / 1000D;
        }

        public static Vec Barycenter(Vec[] points) {
            double x = 0, y = 0;
            for (int i = 0; i < points.length; i++) {
                x += points[i].x;
                y += points[i].y;
            }
            return new Vec(x / points.length, y / points.length);
        }


        public static int sumOfAnglesOfPolygons(int n) {
            return 180 * (n - 2);
        }

        public static double interiorAngle(int n) {
            return sumOfAnglesOfPolygons(n) / n;
        }

        public static double exteriorAngle(int n) {
            return 180-sumOfAnglesOfPolygons(n) / n;
        }

        public static boolean DoesThisDegMakePolygon(int degreeSum) {
            double n = 360 / (180 - degreeSum);
            return ((int) n == n);
        }


        public static int vertexsTOtriangle(int n) {
            return (n * (n - 1) * (n - 2)) / 6;
        }

        public static double circumference(double rodHeight, double shadowLength, double distanceToWell) {
            return distanceToWell / atan(shadowLength / rodHeight) * 2 * PI;
        }

        public static double area(Vec[] coords) {
            double area = 0;
            for (int i = 0, j = coords.length - 1; i < coords.length; i++) {
                area += (coords[j].x - coords[i].x) * (coords[j].y + coords[i].y);
                j = i;
            }
            return (0 < area ? area : -area) / 2;
        }

        public static boolean isInsideTriangle(Vec a, Vec b, Vec c, Vec point) {
            double A = area(new Vec[]{a, b, c});
            double A1 = area(new Vec[]{point, b, c});
            double A2 = area(new Vec[]{a, point, c});
            double A3 = area(new Vec[]{a, b, point});
            return (A == A1 + A2 + A3);
        }


    }


    static class ConvexHull {

        static Vec[] upperHull, lowerHull;

        // returns the hull in CCW order
        public static Vec[] getHull(ArrayList<Vec> pointsV) {
            Vec[] points = new Vec[pointsV.size()];
            for (int i = 0; i < points.length; i++) points[i] = pointsV.get(i);
            points = points.clone();
            Arrays.sort(points);
            if (points.length < 3)
                return upperHull = lowerHull = points;
            int n = points.length, j = 2, k = 2;
            Vec[] lo = new Vec[n], up = new Vec[n];
            lo[0] = points[0];
            lo[1] = points[1];
            for (int i = 2; i < n; i++) {
                Vec p = points[i];
                while (j > 1 && !right(lo[j - 2], lo[j - 1], p)) j--;
                lo[j++] = p;
            }
            up[0] = points[n - 1];
            up[1] = points[n - 2];
            for (int i = n - 3; i >= 0; i--) {
                Vec p = points[i];
                while (k > 1 && !right(up[k - 2], up[k - 1], p)) k--;
                up[k++] = p;
            }

            Vec[] res = new Vec[j + k - 2];
            for (int i = 0; i < k; i++) res[i] = up[i];
            for (int i = 1; i < j - 1; i++) res[k + i - 1] = lo[i];

            // if you need upper and lower hulls
            upperHull = new Vec[k];
            for (int i = 0; i < k; i++) upperHull[i] = up[k - i - 1];
            lowerHull = new Vec[j];
            for (int i = 0; i < j; i++) lowerHull[i] = lo[i];

            return res;
        }

        // check if a->b->c are in the right order
        static boolean right(Vec a, Vec b, Vec c) {
            return b.sub(a).cross(c.sub(a)) > 0;
        }

    }


    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }


    static class Seg {
        Vec o, to, dir;

        public Seg(Vec o, Vec to) {
            this.o = o;
            this.to = to;
            dir = to.sub(o);
        }

        //line-line intersection
        public Vec lineIntersect(Seg point) {
            double det = point.dir.x * dir.y - dir.x * point.dir.y;
            double dist = (point.dir.x * (point.o.y - o.y) - point.dir.y * (point.o.x - o.x)) / det;
            return o.add(dir.scale(dist));
        }

        public Vec getClosestTo(Vec point) {
            double percentThere = point.sub(o).dot(dir) / dir.mag2();
            return o.add(dir.scale(max(0, min(1, percentThere))));
        }

        public Vec projectToLine(Vec point) {
            return dir.scale(point.sub(o).dot(dir) / dir.mag2()).add(o);
        }

        public Seg rotate(double deg) {
            return new Seg(o.rotate(deg), to.rotate(deg));
        }

        //seg-seg intersection
        public Vec segIntersection(Seg point) {
            Vec intersect = lineIntersect(point);
            if (intersect == null) return null;
            return containsPoint(intersect) && point.containsPoint(intersect) ? intersect : null;
        }

        public boolean containsPoint(Vec point) {
            double distFromLine = dir.unit().cross(point.sub(o));
            if (!Vec.eq(distFromLine, 0)) return false;
            return Vec.eq(dir.mag(), o.sub(point).mag() + to.sub(point).mag());
        }

        double orientation(Vec point) {
            return (to.y - o.y) * (point.x - to.x) - (to.x - o.x) * (point.y - to.y);
        }

        public String toString() {
            return o + " -> " + to;
        }
    }

    static class Vec implements Comparable<Vec> {
        static final double eps = 1e-6;
        double x, y;

        public Vec() {
            this.x = 0;
            this.y = 0;
        }

        public Vec(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Vec(double[] point) {
            if (point.length != 2) {
                this.x = 0;
                this.y = 0;
            }
            this.x = point[0];
            this.y = point[1];
        }

        public Vec add(Vec o) {
            return new Vec(x + o.x, y + o.y);
        }

        public Vec sub(Vec o) {
            return new Vec(x - o.x, y - o.y);
        }

        public Vec scale(double s) {
            return new Vec(x * s, y * s);
        }

        public double dot(Vec o) {
            return x * o.x + y * o.y;
        }

        public double cross(Vec o) {
            return x * o.y - y * o.x;
        }

        public double mag2() {
            return dot(this);
        }

        public double mag() {
            return sqrt(mag2());
        }

        public Vec unit() {
            return scale(1 / mag());
        }

        public Vec rot90() {
            return new Vec(-y, x);
        }

        public Vec rot270() {
            return new Vec(y, -x);
        }

        public Vec rotate(double theta) {
            double newX = x * cos(theta) + y * cos(PI / 2 + theta);
            double newY = x * sin(theta) + y * sin(PI / 2 + theta);
            return new Vec(newX, newY);
        }

        //angle between 0 and 2PI
        public double angle() {
            return (atan2(y, x) + 2 * PI) % (2 * PI);
        }

        public String toString() {
            DecimalFormat df = new DecimalFormat("#.##");
            return "(" + df.format(x) + ", " + df.format(y) + ")";
        }

        static boolean eq(double a, double b) {
            return abs(a - b) < eps;
        }


        public void swap(Vec point) {
            double x = point.x, y = point.y;
            point.x = this.x;
            point.y = this.y;
            this.x = x;
            this.y = y;
        }

        public double mag(Vec point) {
            double run = x - point.x;
            double rise = y - point.y;
            return sqrt(run * run + rise * rise);
        }

        public Vec midPoint(Vec point) {
            return new Vec((point.x + x) / 2, (point.y + y) / 2);
        }

        public Vec pol() {
            return new Vec(mag(), atan2(y, x));
        }

        public Vec pol(Vec point) {
            return new Vec(mag(point), atan2(y - point.y, x - point.x));
        }

        public Vec polSq() {
            return new Vec(mag(), (atan2(y, x) * 180) / PI);
        }

        public Vec polSq(Vec point) {
            return new Vec(mag(point), (atan2(point.y - y, point.x - x) * 180) / PI);
        }

        public Vec limit(Vec point) {
            return new Vec(min(point.x, x), max(point.y, y));
        }

        public int manhattan() {
            return (int) (abs(x) + abs(y));
        }

        public int manhattan(Vec point) {
            return (int) (abs(point.x - x) + abs(point.y - y));
        }

        public String limitPrint(Vec point) {
            double X = min(point.x, x);
            double Y = max(point.y, y);
            return "{ " + X + "<= x <=" + Y + " }" + "{ " + X + "<= y <=" + Y + " }";
        }

        public String perpendicularLineEq(Vec o_point, Vec other) {
            double oneMC[] = one_m_c(o_point.x, o_point.y);
            int one = 0, m = 1, c = 2;
            if (oneMC[m] == 0) {
                oneMC[one] = -1;
                oneMC[c] = o_point.y;
                return toStringEq(oneMC);
            } else if (oneMC[one] == 0) {
                oneMC[one] = 1;
                oneMC[m] = 0;
                oneMC[c] = other.y;
                return toStringEq(oneMC);
            }
            oneMC[m] = 1 / -oneMC[m];
            oneMC[c] = other.y - (oneMC[m] * other.x);
            return toStringEq(oneMC);
        }

        public String parallelLineEq(double o_x, double o_y) {
            double oneMC[] = one_m_c(o_x, o_y);
            return toStringEq(oneMC);
        }

        public String straightLineEq() {
            double oneMC[] = one_m_c(0, 0);
            return toStringEq(oneMC);
        }

        public String straightLineEq(double o_x, double o_y) {
            double oneMC[] = one_m_c(o_x, o_y);
            return toStringEq(oneMC);
        }

        public String straightLineEq(Vec o_point) {
            double oneMC[] = one_m_c(o_point.x, o_point.y);
            return toStringEq(oneMC);
        }

        public String toStringEq(double[] oneMC) {
            if (oneMC == null) return null;
            byte one = 0, m = 1, c = 2;
            boolean onemcIsZero[] = new boolean[]{oneMC[one] <= 0, oneMC[m] == 0, oneMC[c] == 0};
            if (onemcIsZero[one] && onemcIsZero[m] && onemcIsZero[c]) {
                return null;
            }
            StringBuilder eq = new StringBuilder();
            if (!onemcIsZero[one]) {
                eq.append("y = ");
                if (onemcIsZero[m] && onemcIsZero[c]) {
                    eq.append(0);
                }
            } else {
                if (!onemcIsZero[c]) {
                    if (oneMC[one] == -1) {
                        eq.append("x = " + oneMC[c]);
                    } else {
                        eq.append("x = " + (-oneMC[c] / oneMC[m]));
                    }
                    return eq.toString();
                } else {
                    eq.append("0 = ");
                }
            }
            if (!onemcIsZero[m]) {
                if (oneMC[m] != 1 && !onemcIsZero[one])
                    eq.append(oneMC[m]);
                eq.append("x ");
            }
            if (!onemcIsZero[c]) {
                if (0 < oneMC[c] && !onemcIsZero[m])
                    eq.append("+");
                eq.append(oneMC[c]);
            }
            return eq.toString();
        }

        public double[] one_m_c(double o_x, double o_y) {
            if (x == o_x && o_y == y) return null;
            double dy = o_y - y, dx = x - o_x, c = dy * x + dx * y;
            if (dx != 0) {
                dy = dy / dx;
                c = c / dx;
                dx = 1;
            }
            double one = dx, m = -dy;
            return new double[]{one, m, c};
        }

        public int signum(double x) {
            if (x > eps) {
                return 1;
            }
            if (x < -eps) {
                return -1;
            }
            return 0;
        }

        public ArrayList<Vec> toArrayList(double[][] points) {
            ArrayList<Vec> stores = new ArrayList<>();
            for (int i = 0; i < points.length; i++) {
                stores.add(new Vec(points[i]));
            }
            return stores;
        }

        public ArrayList<Integer> lineTroughMaxPoints() {

            return null;
        }

        //        @Override
//        public int compareTo(Vec o) {
//            int z = signum(x + y - o.x - o.y);
//            if (z != 0) {
//                return z;
//            }
//            return signum(x - o.x) != 0 ? signum(x - o.x) : signum(y - o.y);
//        }
        public int compareTo(Vec o) {
            if (x != o.x) return Double.compare(x, o.x);
            return Double.compare(y, o.y);
        }
    }

    static class Mid {
        public static void change(int x, int y) {
            x = x - 10;
            y = y - 10;
        }
    }

    public static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction() {
            numerator = 0;
            denominator = 1;
        }

        public Fraction(int num) {
            numerator = num;
            denominator = 1;
        }

        public Fraction(int num, int denom) {
            numerator = (denom < 0 ? -num : num);
            if (denom == 0) {
                denominator = 1;
            }
            denominator = (denom < 0 ? -denom : denom);
            reduce();
        }

        public Fraction(double x) {
            double neg = 1;
            if (x < 0) {
                neg = -1;
                x = -x;
            }
            double tolerance = 1.0E-6, h1 = 1;
            double h2 = 0, k1 = 0;
            double k2 = 1, b = x;
            do {
                double a = Math.floor(b);
                double aux = h1;
                h1 = a * h1 + h2;
                h2 = aux;
                aux = k1;
                k1 = a * k1 + k2;
                k2 = aux;
                b = 1 / (b - a);
            } while (Math.abs(x - h1 / k1) > x * tolerance);

            numerator = (int) (h1 * neg);
            denominator = (int) k1;
        }


        public void setNumerator(int num) {
            numerator = num;
            reduce();
        }

        public int getNumerator() {
            return numerator;
        }

        public void setDenominator(int denom) {
            if (denom > 0) {
                denominator = denom;
                reduce();
            } else if (denom < 0) {
                numerator = -numerator;
                denominator = -denom;
                reduce();
            }
        }

        public int getDenominator() {
            return denominator;
        }

        public Fraction addTo(Fraction rhs) {
            Fraction sum = new Fraction();
            sum.denominator = denominator * rhs.denominator;
            sum.numerator = numerator * rhs.denominator
                    + denominator * rhs.numerator;
            sum.reduce();
            return sum;
        }

        public String toString() {
            return numerator + "/" + denominator;
        }

        public boolean equals(Fraction rhs) {
            return (numerator == rhs.numerator) && (denominator == rhs.denominator);
        }

        private void reduce() {
            int n = numerator, d = denominator, largest;
            if (numerator < 0) {
                n = -numerator;
            }
            if (n > d) {
                largest = n;
            } else {
                largest = d;
            }

            int gcd = 0;
            for (int i = largest; i >= 2; i--) {
                if (numerator % i == 0 && denominator % i == 0) {
                    gcd = i;
                    break;
                }
            }

            if (gcd != 0) {
                numerator /= gcd;
                denominator /= gcd;
            }
        }
    }

    static double orientation(Vec p, Vec q, Vec r) {
        double val = (q.y - p.y) * (r.x - q.x)
                - (q.x - p.x) * (r.y - q.y);

        if (val == 0) {
            return 0; // colinear
        }
        return val;
    }

    public static void main(String[] args) throws IOException {
        Vec c = new Vec(5, 3);
        Vec a = new Vec(3, 2);
        out.println(a.perpendicularLineEq(c,a)+"");
    }





















    /* This is O(scary), but seems quick enough in practice. */

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj).replace("], ", "]\n"));
    }

    static void debugV2(Object... obj) {
        System.out.println(Arrays.deepToString(obj)
                .replace("],", "\n").replace(",", "\t")
                .replaceAll("[\\[\\]]", " "));
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
    // 4:51 PM Mon 01 2021 1/11/2021
}