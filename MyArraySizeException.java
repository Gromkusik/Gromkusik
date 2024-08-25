public class MyArraySizeException extends Exception {
    MyArraySizeException() {
        super(String.format("Вы ввели неверный формат массива. Введите двумерный массив 4х4."));
        printStackTrace();
    }
}
