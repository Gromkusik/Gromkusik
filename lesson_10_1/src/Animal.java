public class Animal {
    private String name;            //кличка животного
    private int age;                //возраст животного
    private int weight;             //вес животного
    private static int counterAnimal; //счетчик экземпляров животных

    //конструктор ===================================================
    public Animal(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        counterAnimal++;
    }

    //геттеры ======================================================
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }
    //геттер счетчика созданных экземпляров
    public static int getCounterAnimal() {
        return counterAnimal;
    }

    //методы =======================================================
    public void run(int distance) {
        //if (obj instanceof C) {//your code } //узнать класс объекта
        //String className = this.getClass().getName();
        if (distance > 0) {
            System.out.println("Животное пробежало " + Integer.toString(distance) + " метров\n");
        }
        else {
            System.out.println("Введите корректное значение\n");
        };
    }

    public void swim(int distance) {
        if (distance > 0) {
            System.out.println("Животное проплыло " + Integer.toString(distance) + " метров\n");
        }
        else {
            System.out.println("Введите корректное значение\n");
        }
    }
}
