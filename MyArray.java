import static javax.swing.text.html.HTML.Attribute.N;

public class MyArray {
    public static int MyArraySum(String[][] myArray) throws MyArrayDataException {
        int mySum = 0;
        int i = 0;
        int j = 0;

        try {
            //проброс исключения при неверном размере массива
            if (myArray.length != 4 || myArray[0].length != 4 || myArray[1].length != 4 || myArray[2].length != 4 || myArray[3].length != 4) {
                throw new MyArraySizeException();
            }
            //подсчет суммы элементов массива
            for (i = 0; i < myArray.length; i++) {
                for (j = 0; j < myArray[i].length; j++) {
                    mySum += Integer.parseInt(myArray[i][j]);
                }
            }
        } catch (MyArraySizeException e) {
        } catch (NumberFormatException e) {
            throw new MyArrayDataException(i, j);
        }
        return mySum;
    }
}