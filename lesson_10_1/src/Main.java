//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Sharik", 8, 15);
        Dog dog2 = new Dog("Barboskin", 4, 10);

        Cat[] catsArray = new Cat[5];
        catsArray[0] = new Cat("Ginger", 5, 5);
        catsArray[1] = new Cat("Pixie", 2, 3);
        catsArray[2] = new Cat("Marvel", 3, 4);
        catsArray[3] = new Cat("Jackie", 4, 3);
        catsArray[4] = new Cat("Gussie", 1, 2);

        Dish catDish1 = new Dish();

        System.out.println("\nВсего животных " + Animal.getCounterAnimal() + ". Из них " + Cat.getCounterCat() + " котиков и " + Dog.getCounterDog() + " пёсиков.\nКотики голодны.\n");

        catsArray[0].run(17);
        catsArray[1].run(2012);
        catsArray[2].swim(150);

        dog1.run(250);
        dog1.run(501);
        dog2.swim(9);
        dog2.swim(11);

        //пополнение миски кормом
        catDish1.setFoodInDish(55);
        catDish1.setFoodInDish(5);

        //кормёжка кота
        for (int i=0; i<5; i++) {
            catsArray[i].catEats(catDish1, 15);
            //проверка сытости кота
            if (catsArray[i].getCatFedUp()) System.out.println(catsArray[i].getName () + " сыт и счастлив.");
            else System.out.println(catsArray[i].getName () + " голоден.");
        }
    }
}