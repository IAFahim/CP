import java.io.*;
import java.nio.file.Path;
import java.util.*;

import static java.lang.Math.*;

public class GenerateRandomPassportInfo {
    //    public class Main {
    static Random random = new Random();

    static String FirstNameRandom() {
        return firstNameArray[random.nextInt(firstNameArray.length)];
    }

    static String LastNameRandom() {
        return lastNameArray[random.nextInt(firstNameArray.length)];
    }

    static String NIDRandom() {
        StringBuilder NID = new StringBuilder(random.nextInt(9) + 1);
        for (int j = 0; j < 9; j++) {
            NID.append(random.nextInt(10));
        }
        return NID.toString();
    }
    
    static Color[][] PictureRandom(){
        Color picture[][]=new Color[1024][768];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                picture[i][j]=new Color();
                picture[i][j].setRed(random.nextInt(256));
                picture[i][j].setGreen(random.nextInt(256));
                picture[i][j].setBlue(random.nextInt(256));
            }
        }
        return picture;
    }

    static DateOfBirth dateOfBirthRandom(){
        int day=random.nextInt(30);
        int month=random.nextInt(12);
        int year=1940+random.nextInt(2000-1940);
        return new DateOfBirth(day,month,year);
    }

    static String NIDSerch(PassportInfo passportInfo[],String NID){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < passportInfo.length; i++) {
            if(passportInfo[i]!=null && passportInfo[i].getNIDNumber().equalsIgnoreCase(NID)){
                sb.append(passportInfo[i].toString());
            }
        }
        if(sb.length()>1){
            return sb.toString();
        }
        return "Passport not found";
    }

    public static void main(String[] args) throws IOException {
        PassportInfo passportInfo[] = new PassportInfo[100];
        for (int i = 0; i < 100; i++) {
            passportInfo[i] = passportInfo[i].Builder();
            passportInfo[i].setFirstName(FirstNameRandom());
            passportInfo[i].setLastName(LastNameRandom());
            passportInfo[i].setNIDNumber(NIDRandom());
            passportInfo[i].setDateOfBirth(dateOfBirthRandom());
            passportInfo[i].setPicture(PictureRandom());
        }
        Scanner sc=new Scanner(System.in);
        System.out.println(NIDSerch(passportInfo,sc.nextLine()));
    }

    private static String firstNameArray[] = {"Freeda",
            "Glennie",
            "Cyndy",
            "Star",
            "Tammi",
            "Iliana",
            "Cecil",
            "Hassie",
            "Lannie",
            "Anja",
            "Sherlyn",
            "Oretha",
            "Owen",
            "Angeles",
            "Anita",
            "Aurora",
            "Argentina",
            "Dara",
            "Heike",
            "An",
            "Lauran",
            "Eufemia",
            "Shalon",
            "Onita",
            "Cathi",
            "Joanie",
            "Dawn",
            "Ashlie",
            "Danelle",
            "Conrad",
            "Myrl",
            "Vernita",
            "Sean",
            "Edda",
            "Keneth",
            "Arnette",
            "Lynsey",
            "Douglass",
            "Lien",
            "Chung",
            "Quintin",
            "Estefana",
            "Kyla",
            "Ayako",
            "Harris",
            "Jule",
            "Gail",
            "Yvonne",
            "So",
            "Tesha"};
    private static String lastNameArray[] = {"Micheline",
            "Chaya",
            "Milagro",
            "Erasmo",
            "Jamison",
            "Amos",
            "Ferne",
            "Maegan",
            "Ena",
            "Simona",
            "Madison",
            "Thea",
            "Fonda",
            "Ricarda",
            "Meg",
            "Edith",
            "Kimbra",
            "Gabriele",
            "Londa",
            "Brittani",
            "Lisa",
            "Letitia",
            "Sarita",
            "Keitha",
            "Marylou",
            "Hye",
            "Oma",
            "Raguel",
            "Stephane",
            "Darius",
            "Freeda",
            "Spencer",
            "Darrel",
            "Genaro",
            "Dorthey",
            "Joshua",
            "Letty",
            "Candie",
            "Jo",
            "Letisha",
            "Jannette",
            "Janna",
            "Barrie",
            "Leona",
            "Yang",
            "Tu",
            "Jarod",
            "Tameka",
            "Kimberely",
            "Dominica"};
    // 8:20 PM Mon 04 2021 4/19/2021
}