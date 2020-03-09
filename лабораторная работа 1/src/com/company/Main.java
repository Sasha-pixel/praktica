package com.company;
import java.lang.String;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите первую строку\n");
        String S1 = in.nextLine();
        System.out.print("Введите вторую строку\n");
        String S2 = in.nextLine();
        Map<Character,Integer> dictionary = new HashMap<Character,Integer>();
        boolean prov = true;
        int rep;
        if (S1.length() != S2.length())
            System.out.print("\nВведённые строки не эдентичны\n");
        else {
            for (int i = 0; i < S1.length(); i++) {
                rep = 1;
                if (dictionary.containsKey(S1.charAt(i))) {
                    rep = dictionary.get(S1.charAt(i));
                    rep++;
                }
                dictionary.put(S1.charAt(i), rep);
            }
            for (int i = 0; i < S1.length(); i++) {
                if (dictionary.containsKey(S2.charAt(i))) {
                    rep = dictionary.get(S2.charAt(i));
                    rep--;
                    dictionary.put(S2.charAt(i), rep);
                    if (dictionary.get(S2.charAt(i)) == 0) {
                        dictionary.remove(S2.charAt(i));
                    }
                } else {
                    prov = false;
                    break;
                }
            }
            if (prov && dictionary.size() == 0)
                System.out.print("\nВведённые строки эдентичны\n");
            else
                System.out.print("\nВведённые строки не эдентичны\n");
        }
    }
}