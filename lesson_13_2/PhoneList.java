package lesson_13_2;

import java.util.HashMap;
import java.util.Map;

public class PhoneList {
    HashMap <String, String> hm = new HashMap<>();
    public PhoneList() {}

    //метод добавления пары ключ-значение
    public void add (String name, String phone) {
        hm.put(phone, name);
        System.out.println("Контакт \"" + name + " (" + phone + ")\" успешно добавлен в телефонный справочник");
    }

    //метод поиска по фамилии
    public void get(String name) {
        int i = 0;
        System.out.println("\nРезультат поиска \"" + name +"\":");
        for (Map.Entry<String, String> o : hm.entrySet()) {
            if (o.getValue().toLowerCase().contains(name.toLowerCase())) {
                i++;
                System.out.println(i + ") " + o.getValue() + " : \t" + o.getKey());
            }
        }
        if (i == 0) System.out.println("Контакты по фамилии \"" + name + "\" не найдены");
    }
}
