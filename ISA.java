import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class ISA {


    private class Opn {
        private String operationText;
        private String readInstruction;
        private String writeInstruction;

        Opn(String operationText, String readInstruction, String writeInstruction) {
            this.operationText = operationText;
            this.readInstruction = readInstruction;
            this.writeInstruction = writeInstruction;
        }
    }

    private HashMap<String, Opn> opn;
    private HashMap<String, String> storage;
    private static ArrayList<String[]> commandLogMap;

    enum Type {
        ASSEMBLY,
        BINARY,
        HEX
    }

    String assmeblyCode(Type type) {
        StringBuilder outputSteam = new StringBuilder();
        for (int x = 0; x < commandLogMap.size(); x++) {
            Opn o = opn.get(commandLogMap.get(x)[0]);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < o.readInstruction.length(); i++) {
                if(o.readInstruction.charAt(i) == 'z'){
                    if(type==Type.BINARY){
                        sb.append("0000");
                    }else if(type==Type.HEX){
                        sb.append(hex("0000"));
                    }
                }else if (o.writeInstruction.charAt(i) == 'o') {
                    if (type == Type.ASSEMBLY) {
                        if (o.writeInstruction.charAt(i) == 'o') sb.append(o.operationText + " ");
                    } else if (type == Type.BINARY) {
                        sb.append(commandLogMap.get(x)[(int) (o.readInstruction.charAt(i) - '0')]);
                    } else {
                        sb.append(hex(commandLogMap.get(x)[(int) (o.readInstruction.charAt(i) - '0')]));
                    }
                } else {
                    if (o.writeInstruction.charAt(i) == 'v') {
                        if (type == Type.ASSEMBLY) {
                            sb.append(storage.get(commandLogMap.get(x)[(int) (o.readInstruction.charAt(i) - '0')]) + " ");
                        } else if (type == Type.BINARY) {
                            sb.append(commandLogMap.get(x)[(int) (o.readInstruction.charAt(i) - '0')]);
                        } else {
                            sb.append(hex(commandLogMap.get(x)[(int) (o.readInstruction.charAt(i) - '0')]));
                        }
                    } else {
                        if (type == Type.ASSEMBLY) {
                            if (o.writeInstruction.charAt(i) == 'V') {
                                sb.replace(sb.length() - 1, sb.length(), "(");
                                sb.append(storage.get(commandLogMap.get(x)[(int) (o.readInstruction.charAt(i) - '0')]));
                                sb.append(") ");
                            } else {
                                sb.append(hex(commandLogMap.get(x)[(int) (o.readInstruction.charAt(i) - '0')]) + " ");
                            }
                        } else if (type == Type.BINARY) {
                            sb.append(commandLogMap.get(x)[(int) (o.readInstruction.charAt(i) - '0')]);
                        } else {
                            sb.append(hex(commandLogMap.get(x)[(int) (o.readInstruction.charAt(i) - '0')]));
                        }
                    }
                }
            }
            if (type == Type.ASSEMBLY) {
                outputSteam.append(sb.substring(0, sb.length() - 1) + ((x == commandLogMap.size() - 1) ? "" : "\n"));
            }else {
                outputSteam.append(sb.toString()+((x == commandLogMap.size() - 1) ? "" : "\n"));
            }
        }
        return outputSteam.toString();
    }

    String oxxh[] = new String[]{"0zz3", "ozzH",
            "1111", "j"};
    String oVVh[] = new String[]{"0213", "ovvH",
            "1001", "addi",
            "1010", "andi",
            "1011", "ori",
            "0111", "beq",
            "1100", "sll",
            "1101", "srl"};
    String oVhV[] = new String[]{"0231", "ovHV",
            "0101", "lw",
            "0110", "sw"};
    String oVVV[] = new String[]{"0312", "ovvv",
            "0000", "add",
            "0001", "sum",
            "0010", "and",
            "0011", "or",
            "0100", "nor",
            "1110", "xor"};


    private void builder() {
        opn = new HashMap<>();
        storageBuilder();
        oppBuilder(oxxh);
        oppBuilder(oVVh);
        oppBuilder(oVhV);
        oppBuilder(oVVV);
        commandLogMap = new ArrayList<>();

    }

    private void storageBuilder() {
        storage = new HashMap<>();
        for (int i = 1; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            for (int n = bit - 1; n >= 0; n--) {
                sb.append((((i & (1 << n)) != 0) ? '1' : '0'));
            }
            storage.put(sb.toString(), (i <= totalTempSize) ? "$t" + (i - 1) : "$s" + (i - 1 - totalTempSize));
        }
    }

    private void oppBuilder(String str[]) {
        for (int i = 2 + 1; i < str.length; i += 2) {
            Opn temp = new Opn(str[i], str[0], str[1]);
            opn.put(str[i - 1], temp);
        }
    }

    private int bit = 0, totalTempSize = 0, saveSize = 0, size = 0;
    protected final int fragment_size = 4;
    private String filepath;

    public void writeToFile(String outPath) {
        try {
            FileWriter fileWriter = new FileWriter(outPath);
            for (int i = 0; i < commandLogMap.size(); i++) {
                fileWriter.write(hexPrint(commandLogMap.get(i)) + ((i == commandLogMap.size() - 1) ? "" : "\n"));
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readFormFile() {
        try {
            File file = new File(filepath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                int at = 0;
                String command = sc.nextLine();
                String opporation = command.substring(at, at += bit), storeAt = command.substring(at, at += bit), first = command.substring(at, at += bit), second = command.substring(at, at += bit);
                String fragment[] = new String[]{opporation, storeAt, first, second};
                commandLogMap.add(fragment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ISA(int bit, int totalTempSize, String filepath, String outpath) {
        this.bit = bit;
        this.totalTempSize = totalTempSize;
        this.filepath = filepath;
        size = (1 << bit);
        saveSize = size - totalTempSize;

        builder();
        readFormFile();

    }

    private String hexPrint(String str[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(hex(str[i]));
        }
        return sb.toString();
    }

    public String hex(String binary) {
        return Integer.toString(Integer.parseInt(binary, 2), 16).toUpperCase();
    }

    public static void main(String[] args) throws IOException {
        ISA isa = new ISA(4, 7, "assemblyFile.txt", "output.txt");
        System.out.println(isa.assmeblyCode(Type.HEX));
        isa.writeToFile("output.txt");
    }

}