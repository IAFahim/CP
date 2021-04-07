package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

abstract class GeometricObject {
    protected GeometricObject() {
        super();
    }

    public abstract double getArea();
}


class Rhombus extends GeometricObject implements Cloneable {
    private int s;
    private double h;

    public Rhombus(int s, double h) {
        if (s > 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getArea() {
        return s * h;
    }

}

//Write another class named Trapezoid that extends abstract GeometricObject class and
//implements the Cloneable interface. The Trapezoid class throws an
//IllegalArgumentException when side is negative. Assume you are given the length of
//parallel sides (a and b) and the perpendicular height (h) to the parallel sides. The area
//can be computed using the following formula:
class Trapezoid extends GeometricObject implements Cloneable {
    private double a, b, h;

    public Trapezoid(double a, double b, double h) {
        if (a > 0 || b > 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getArea() {
        return .5 * (a + b) * h;
    }
}

class here {
    public static void main(String[] args) {
        int x = 7;
        GeometricObject geometricObject[] = new GeometricObject[x];
        Scanner scanner = new Scanner(System.in);
        try {
            OutputStream out = new FileOutputStream("test.txt");
            int pick = scanner.nextInt();
            if (pick == 1) {
                for (int i = 0; i < x; i++) {
                    Rhombus rhombus = new Rhombus(scanner.nextInt(), scanner.nextDouble());
                    out.write((int)rhombus.getArea());
                }
            } else {
                for (int i = 0; i < x; i++) {
                    Trapezoid trapezoid= new Trapezoid(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
                    out.write((int)trapezoid.getArea());
                }

            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}