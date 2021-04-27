import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class rajAssigment5 {

    public static void main(String[] args) throws IOException, ParseException {
        File file = new File("C:\\Users\\Fahim\\IdeaProjects\\CP\\data.txt");
        Scanner sc = new Scanner(file);
        ArrayList<PassportPerson> passportPeople = new ArrayList<>();
        while (sc.hasNextLine()) {
            passportPeople.add(new PassportPerson(sc.next(), sc.next(), sc.next(), sc.next(), sc.next()));
            if (sc.hasNext()) sc.nextLine();
        }
        sc.close();

        List<PassportPerson> sortedByPassport = passportPeople.stream().sorted(Comparator.comparing(PassportPerson::getPassportNumber)).collect(Collectors.toList());
        FileWriter fileWriter = new FileWriter("C:\\Users\\Fahim\\IdeaProjects\\CP\\SortedByPassport.txt");
        try {
            for (PassportPerson passportInfo : sortedByPassport) {
                fileWriter.write(passportInfo.toString() + '\n');

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        fileWriter.close();
        fileWriter = new FileWriter("C:\\Users\\Fahim\\IdeaProjects\\CP\\SortedByDOB.txt");
        List<PassportPerson> sortedByDOB = passportPeople.stream().sorted(Comparator.comparing(PassportPerson::getDateOfBirth)).collect(Collectors.toList());
        try {
            for (PassportPerson passportInfo : sortedByDOB) {
                fileWriter.write(passportInfo.toString() + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileWriter.close();
    }
}