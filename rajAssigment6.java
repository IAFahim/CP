import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class rajAssigment6 {

    public static void main(String[] args) throws IOException, ParseException {
        File file = new File("C:\\Users\\Fahim\\IdeaProjects\\CP\\data.txt");
        Scanner sc = new Scanner(file);
        ArrayList<PassportPerson> passportPeople = new ArrayList<>();
        while (sc.hasNextLine()) {
            passportPeople.add(new PassportPerson(sc.next(), sc.next(), sc.next(), sc.next(), sc.next()));
            if (sc.hasNext()) sc.nextLine();
        }
        sc.close();
        TreeMap<String, ArrayList<PassportPerson>> map = new TreeMap<>();
        for (int i = 0; i < passportPeople.size(); i++) {
            if (!map.containsKey(passportPeople.get(i).getnID())) {
                map.put(passportPeople.get(i).getnID(), new ArrayList<>());
                map.get(passportPeople.get(i).getnID()).add(passportPeople.get(i));
            } else {
                map.get(passportPeople.get(i).getnID()).add(passportPeople.get(i));
            }
        }
        FileWriter fileWriter = new FileWriter("C:\\Users\\Fahim\\IdeaProjects\\CP\\Mapsorted.txt");
        try {
            for (String string : map.keySet()) {
                fileWriter.write(string.toString()+' ');
                for (int i = 0; i < map.get(string).size() - 1; i++) {
                    fileWriter.write(map.get(string).get(i).toString() + ", ");
                }
                fileWriter.write(map.get(string).get(map.get(string).size()-1).toString());
                fileWriter.write('\n');
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        fileWriter.close();

    }
}