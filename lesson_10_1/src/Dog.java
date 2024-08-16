public class Dog extends Animal{
    private static int counterDog; //счетчик экземпляров Пса
    //конструктор =================================================
    public Dog(String name, int age, int weight) {
        super(name, age, weight);
        counterDog++;
    }

    //геттер счетчика созданных экземпляров пёсиков
    public static int getCounterDog() {
        return counterDog;
    }

    //методы =======================================================
    @Override
    public void run(int distance) {
        if (distance<=500 && distance>0) {
            System.out.println(getName() + " пробежал " + Integer.toString(distance) + " метров.");
        }
        else if (distance>500) {
            System.out.println(getName() + " не побежит " + distance + " метров. Пёс не осилит дистанцию больше 500 метров.");
        }
        else {
            System.out.println("Введите положительное целочисленное значение дистанции забега.");
        };
    }

    @Override
    public void swim(int distance) {
        if (distance > 0 && distance<=10) {
            System.out.println(getName() + " проплыл " + Integer.toString(distance) + " метров.");
        }
        else if (distance>10) {
            System.out.println(getName() + " не поплывёт " + distance + " метров. Пёсик не проплывёт дистанцию больше 10 метров.");
        }
        else {
            System.out.println("Введите положительное целочисленное значение дистанции заплыва.");
        }
    }
}
