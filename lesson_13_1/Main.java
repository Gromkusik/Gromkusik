package lesson_13_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Привет");
        myList.add("Hi");
        myList.add("Salut");
        myList.add("Hola");
        myList.add("Ciao");
        myList.add("Cześć");
        myList.add("Cześć");
        myList.add("Selam");
        myList.add("Hej");
        myList.add("你好");
        myList.add("你好");
        myList.add("你好");
        myList.add("你好");
        myList.add("הַיי");
        myList.add("הַיי");
        myList.add("הַיי");
        myList.add("הַיי");
        myList.add("הַיי");
        myList.add("Ahoj");
        myList.add("नमस्ते");
        myList.add("Terve");
        myList.add("Szia");
        myList.add("Γειά σας");

        Set<String> uniqueList = new HashSet<>(myList);
        System.out.println(uniqueList);
        System.out.println("В исходном списке " + myList.size() + " элементов.");
        System.out.println("Уникальных зэлементов " + uniqueList.size() + ".");

        for (String s : uniqueList) {
            int count = Collections.frequency(myList, s);
            if (count == 1) {
                System.out.println("Элемент \"" + s + "\" не повторяется.");
            } else {
                System.out.println("Элемент \"" + s + "\" присутствует в количестве " + count + " штук.");
            }
        }
    }
}