import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class testimage {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Users\\ANO\\Videos\\Radeon ReLive\\mems\\pixil-frame-0.png");
        BufferedImage image = ImageIO.read(file);
        int A[][] = new int[image.getHeight()][image.getWidth()];
        int R[][] = new int[image.getHeight()][image.getWidth()];
        int G[][] = new int[image.getHeight()][image.getWidth()];
        int B[][] = new int[image.getHeight()][image.getWidth()];
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int at = image.getRGB(x, y);
                int a = at >> 24 & 0xff;
                int r = at >> 16 & 0xff;
                int g = at >> 8 & 0xff;
                int b = at & 0xff;
                A[y][x] = a;
                R[y][x] = r;
                G[y][x] = g;
                B[y][x] = b;
                image.setRGB(x, y, at);
            }
        }
//        print2darray(A);
//        print2darray(R);
//        print2darray(G);
//        print2darray(B);
        File write = new File("D:\\Users\\ANO\\Videos\\Radeon ReLive\\mems\\out.jpg");
        ImageIO.write(image, "png", write);
    }

    static void print2darray(int A[][]){
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[j][i]+" w");
            }
            System.out.println();
        }
    }

}