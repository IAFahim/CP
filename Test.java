package com.company;

import com.company.Drawable;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Test {
    //    public class Main {

    public static void main(String[] args) throws IOException {
        int x = 3;
        GeometricObject[] shapes = new GeometricObject[x];

        for (int i = 0; i < x; i++) {
            if (shapes[i] instanceof Drawable){
                ((Drawable) shapes[i]).HowtoDraw();
            }
            System.out.println(shapes[i].getArea());
        }
    }

}