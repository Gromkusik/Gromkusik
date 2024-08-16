public class Dish {
    private int FoodInDish;

    //конструктор
    public Dish() {
        this.FoodInDish = 0;
    }

    //увеличение количества корма в миске
    public void setFoodInDish(int amountOfFood) {
        FoodInDish += amountOfFood;

        if (amountOfFood>0) {
            System.out.println("\nМиска пополнилась на " + amountOfFood + ", и теперь в ней " + FoodInDish + " корма.\n");
        }
    }



    //получение количества корма в миске
    public int getFoodInDish() {
        return FoodInDish;
    }
}
