public class MyArrayDataException extends NumberFormatException {
    MyArrayDataException(int row, int col) {
        super(String.format("Неверный формат данных в ячейке массива [%d][%d]. Введите массив целых чисел 4х4.", row, col));
    }
}
