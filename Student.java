package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Student {
    private String name;

        Student(String n){
            name=n;
        }

        public String getName(){
            return name;
        }

        public void setName(String n){
            this.name=n;
        }
}