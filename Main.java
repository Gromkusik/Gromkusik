public class Main {
    public static void main(String[] args) {
        //объявляем массивы
        String[][] correctArray =    {{"1", "1", "1", "1"},
                                      {"1", "1", "1", "1"},
                                      {"1", "1", "1", "1"},
                                      {"1", "1", "1", "1"}};

        String[][] incorrectArray1 =   {{"1", "1", "1", "1", "5"},
                                        {"1", "1", "1", "1"},
                                        {"1", "1", "1", "1"},
                                        {"1", "1", "1", "1"}};

        String[][] incorrectArray2 =   {{"1", "1", "1", "1"},
                                        {"1", "1", "1", "1"},
                                        {"1", "1", "qwerty", "1"},
                                        {"1", "1", "1", "1"}};

        //вызываем метод подсчета суммы элементов массива
        System.out.println("\nСумма элементов массива равна " + MyArray.MyArraySum(correctArray));
        System.out.println("\nСумма элементов массива равна " + MyArray.MyArraySum(incorrectArray1));
        System.out.println("\nСумма элементов массива равна " + MyArray.MyArraySum(incorrectArray2));
    }
}