public class Cat extends Animal{
    private static int counterCat; //счетчик экземпляров котиков
    private boolean catFedUp; //кот сыт или голоден

    //конструктор =================================================
    public Cat(String name, int age, int weight) {
        super(name, age, weight);
        counterCat++;
        this.catFedUp = false;
    }

    //геттер счетчика созданных экземпляров котиков
    public static int getCounterCat() {
        return counterCat;
    }

    public boolean getCatFedUp() {
        return catFedUp;
    }

    //методы =======================================================
    @Override
    public void run(int distance) {
        if (distance<=200  && distance>0) {
            System.out.println(getName() + " пробежал " + distance + " метров.");
        }
        else if (distance>200) {
            System.out.println(getName() + " не побежит. Котик не осилит дистанцию больше 200 метров.");
        }
        else {
            System.out.println("Введите положительное целочисленное значение дистанции забега.");
        };
    }

    @Override
    public void swim(int distance) {
        if (distance > 0) {
            System.out.println(getName() + " не поплывёт. Котики не умеют плавать.");
        }
        else {
            System.out.println("Введите положительное целочисленное значение дистанции заплыва.");
        }
    }

    //метод Котик кушает =======================================================
    public void catEats (Dish catDish, int portionOfFood) {
        if (catDish.getFoodInDish()>=portionOfFood) {
            catDish.setFoodInDish(-portionOfFood);
            catFedUp = true;
            System.out.println(getName() + " съел " + portionOfFood + ", в миске осталось " + catDish.getFoodInDish() + " корма. Котик сыт.");
        } else {
            System.out.println("В миске не хватило корма для " + getName() + ". Пополните миску.");
        }
    }


}
