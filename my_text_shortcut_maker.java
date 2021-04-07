package com.company;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class my_text_shortcut_maker {
    //    public class Main {

    static Scanner sc = new Scanner(System.in);

    static void print(String str, int i) {
        System.out.println("::_" + str.substring(0, i) + "::" + str.substring(i + 1, str.length() - 1));
    }

    static void G_board_to_Hotkeys() {
        while (true) {
            char str[] = sc.nextLine().toCharArray();
            if (str.length > 0 && str[0] == '1') {
                break;
            } else if (str.length > 0 && str[0] == '#') {
                continue;
            } else
                for (int i = 1; i < str.length - 1; i++) {
                    if (str[i] == '\t') {
                        print(String.valueOf(str), i);
                    }
                }
        }
    }

    static void HotkeyCleanUp() {
        TreeMap<String, String> map = new TreeMap<>();
        while (true) {
            String str = sc.nextLine();
            if (str.length() == 0) {
                break;
            }
//            System.out.println(String.valueOf(str)+" "+str.length);
            int st = 0, end = 4;
            for (int i = 2; i < str.length(); i++) {
                if (str.charAt(i - 2) == ':' && str.charAt(i - 1) == ':') {
                    st = i;
                    break;
                }
            }
            for (int i = st + 2; i < str.length(); i++) {
                if (str.charAt(i) == ':' && str.charAt(i - 1) == ':') {
                    end = i + 2;
                    break;
                }
            }
            if (st != 0) {
                String at = str.substring(st, end - 3).toLowerCase();
                if (map.get(at) == null)
                    map.put(at, str.substring(end - 1, str.length()));
                else {
                    int i = 0;
                    while (true) {
                        String bt = str.substring(st, end - 3).toLowerCase() + i;
                        if (map.get(bt) == null) {
                            map.put(bt, str.substring(end - 1, str.length()));
                            break;
                        }
                        i++;
                    }
                }
                //                System.out.println(st + " " + end);
            }
        }

        for (String s : map.keySet()) {
            System.out.println("::_" + s + "::" + map.get(s));
        }

    }

    public static void add_For_first_time() {
        while (true) {
            String str = sc.nextLine();
            if (str.length() == 0) {
                break;
            }
            int st = 3;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '\t') {
                    st = i;
                    break;
                }
            }
            print(str, st);
        }
    }

    public static void hotkey_to_google_key() {
        TreeMap<String, String> map = new TreeMap<>();
        while (true) {
            String str = sc.nextLine();
            if (str.length() == 0) {
                break;
            }
            int st = 0, end = 4;
            for (int i = 2; i < str.length(); i++) {
                if (str.charAt(i - 2) == ':' && str.charAt(i - 1) == ':') {
                    st = i;
                    break;
                }
            }
            for (int i = st + 2; i < str.length(); i++) {
                if (str.charAt(i) == ':' && str.charAt(i - 1) == ':') {
                    end = i + 2;
                    break;
                }
            }
            if (st != 0) {
                String at = str.substring(st + 1, end - 3).toLowerCase();
                map.put(at, str.substring(end - 1, str.length()));
            }

        }
        for (String s : map.keySet()) {
            System.out.println(s + '\t' + map.get(s));
        }
    }


    public static void csv_to_Hotkey() {
        ArrayList<String> avvry = new ArrayList<>();
        int pick_heads = 0;
        String head = sc.nextLine();
        if (head.length() != 0) {
            String heads[] = head.split(",(?=([^\"]|\"[^\"]*\")*$)");
            for (int i = 0; i < heads.length; i++) {
                StringBuilder at = new StringBuilder();
                String indi = heads[i].strip();
                if (indi.length() > 0) {
                    at.append(indi.charAt(0));
                }
                for (int j = 1; j < indi.length(); j++) {
                    if ('A' <= indi.charAt(j) && indi.charAt(j) <= 'Z') {
                        at.append(indi.charAt(j));
                    }
                }
                avvry.add(at.toString());
                System.out.println("::_" + avvry.get(i) + "::" + indi);
            }
            while (true) {
                String second_line = sc.nextLine();
                if (second_line.length() != 0) {
                    String second_lines[] = second_line.split(",(?=([^\"]|\"[^\"]*\")*$)");
                    if (heads.length == second_lines.length) {
                        for (int i = 0; i < second_lines.length; i++) {
                            if (pick_heads != 0)
                                break;
                            for (int j = 0; j < second_lines[i].length(); j++) {
                                if (second_lines[i].length() > 0 && '0' <= second_lines[i].charAt(j) && second_lines[i].charAt(j) <= '9') {
                                    break;
                                }
                                pick_heads = i;
                                break;
                            }
                        }
                        System.out.print("::_" + second_lines[pick_heads].strip() + "::");
                        for (int i = 0; i < heads.length; i++) {
                            if (i != pick_heads && second_lines[i].length()!=0) {
                                String pasto=second_lines[i].strip();
                                if(pasto.length()>3 && pasto.charAt(0)=='"'&& pasto.charAt(pasto.length()-1)=='"')
                                    System.out.print(pasto.substring(1,pasto.length()-1) + " " + avvry.get(i) + "    ");
                                else{
                                System.out.print(pasto + " " + avvry.get(i) + "    ");
                                }
                            }
                        }
                        System.out.println();
                    }
                } else {
                    break;
                }

            }
        }


//        while (true) {
//            String str = sc.nextLine();
//            if (str.length() == 0) {
//                break;
//            }
//            String[] strings = str.split(",");
////            StringBuilder[] capital=new StringBuilder[str.length()];
////            for (int i = 0; i < head.length; i++) {
////
////            }
//        }

    }

    static double f(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 3;
        }
        if (n > 2) {
            if (((n & 1) == 0))
                return Math.sqrt(f(n - 1)) + Math.pow(f(n - 2), 1 / (n - 2));
            else {
                Math.pow(f(n - 1), 1.000001);
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        int at = 0;
        String pick_string = """
                    Add new (Tab sep/ Auto) [1]
                    GBoard to AutoHotKeys   [2]
                    AutoHotKeys cleanup     [3]
                    CSV to AutoHotKeys      [4]
                Pick one:
                """;
        while (true) {
            System.out.print(pick_string);
//            char str[] = sc.next().toCharArray();
            char str[] = new char[1];
            str[0] = '5';
            if (str.length == 1)
                if (str[0] == '2') {
                    sc.nextLine();
                    G_board_to_Hotkeys();
                } else if (str[0] == '3') {
                    sc.nextLine();
                    HotkeyCleanUp();
                    break;
                } else if (str[0] == '1') {
                    sc.nextLine();
                    add_For_first_time();
                    break;
                } else if (str[0] == '4') {
                    sc.nextLine();
                    hotkey_to_google_key();
                    break;
                } else if (str[0] == '5') {
//                    sc.nextLine();
                    csv_to_Hotkey();
                    break;
                }
        }


        close.close();
    }






















    /* This is O(scary), but seems quick enough in practice. */

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj).replace("], ", "]\n"));
    }

    static void debugV2(Object... obj) {
        System.out.println(Arrays.deepToString(obj)
                .replace("],", "\n").replace(",", "\t")
                .replaceAll("[\\[\\]]", " "));
    }


    static class Print {
        private final OutputStream out;

        public Print() {
            this.out = System.out;
        }

        public void print(String str) throws IOException {
            for (int i = 0; i < str.length(); i++) {
                out.write(str.charAt(i));
            }
        }

        public void println(String str) throws IOException {
            print(str);
            out.write('\n');
        }

        public void close() throws IOException {
            out.close();
        }
    }

    static Print out = new Print();
    static BufferedWriter close = new BufferedWriter(new OutputStreamWriter(System.out));
    // 4:51 PM Fri 03 2021 3/12/2021
}