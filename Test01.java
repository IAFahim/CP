import java.io.*;
import java.util.*;
import static java.lang.Math.*;
public class Test01 {
    public static Plant [] plants = new Plant [5];
    public static int plantCount = -1;
    public static int findPLant = -1;
    public static void main(String[] args) {
        Plant p1 = new Plant("Almond", "Brown");
        add(p1);
        display();
        p1 = new Herb("Tulsi", "Green", true, "All");
        add(p1);
        display();
    }

    public static void add(Plant p) {
        plants[plantCount++] = p;
        //String name = p.getName();
        //String color = p.getColor();
        //p = new Plant(name, color);
        //plants [0] = new Plant(name, color);

//        p = new Herb(n, c, medicinal,season);
		/*String name2 = p.getName();
		String color2 = p.getColor();
		boolean isMedicinal = p.getisMedicinal();
		String Season = p.getSeason();*/
        //plants[1] = new Herb(p.getName(), p.getColor(), p.getClass(), p.getisMedicinal());

        //p = new Herb
    }

    public static void display() {
        for(int i=0; i<5; ++i) {
            System.out.println(plants[i].toString());
        }
    }
}