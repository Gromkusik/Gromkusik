package lesson_13_2;

public class Main {
    public static void main(String[] args) {
        PhoneList pl1 = new PhoneList();
        pl1.add("Петров", "8 911 111 11 11");
        pl1.add("Иванов", "8 922 222 22 22");
        pl1.add("Сидоров А.В.", "8 933 333 33 33");
        pl1.add("Петров П.", "8 944 444 44 44");
        pl1.add("Сидоров В.Г.", "8 955 555 55 55");
        pl1.add("Сидоров А.", "8 966 666 66 66");

        pl1.get("СИДОРОв");
        pl1.get("Петров");
        pl1.get("иванов");
        pl1.get("ксенофонтов");
    }
}