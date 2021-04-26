import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class vhiaAt3rdCLassJava {
    //    public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int value = input.nextInt();
        input.nextLine();
        Plant [] plants = new Plant[value];
        add(plants);
        for (int i = 0; i < plants.length; i++) {
            System.out.println(plants[i]);
        }
        String s=input.next();
        System.out.println(Search(plants,s));
        input.close();
    }

    public static void add(Plant[] plants) {
        for(int i=0; i<plants.length; i++) {
            String name = input.next();
            String color = input.next();
            String type = input.next();
            input.nextLine();
            plants [i] = new Plant(name, color, type);
        }
    }

    public static String Search (Plant [] plants, String s) {
        String str=new String();
        for(int i=0; i<plants.length; i++) {
            if(plants[i].getType().equalsIgnoreCase(s)) {
               str+=plants[i].getName()+" ";
            }
        }
        return str;
    }


    static class Plant{
        private String name;
        private String color;
        private String type;
        public Plant(String name, String color, String type) {
            super();
            this.name = name;
            this.color = color;
            this.type = type;
        }
        public String getName() {
            return name;
        }
        public String getColor() {
            return color;
        }
        public String getType() {
            return type;
        }
        public String toString() {
            return getName();
        }
    }
    // 10:32 PM Fri 04 2021 4/16/2021
}