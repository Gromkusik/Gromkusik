public class Rectangle extends Figure {
    private int a, b;

    //конструктор
    public Rectangle(String fillingColor, String outlineColor, int a, int b) {
        super(fillingColor, outlineColor);
        this.a = a;
        this.b = b;
    }

    //вывод инфо о фигуре
    public void info() {
        System.out.println( "\nСтороны прямоугольника: " + this.a + "x" + this.b + "\n" +
                "Цвет заливки: " + this.getFillingColor() + "\n" +
                "Цвет границ: " + this.getOutlineColor() + "\n" +
                "Площадь: " + this.Square() + "\n" +
                "Периметр: " + this.Perimeter() + "\n");
    }

    //ФОРМУЛА ПЛОЩАДИ
    @Override
    public double Square() { //площадь круга (радиус)
        return a * b;
    }

    //ФОРМУЛА ПЕРИМЕТРА
    @Override
    public double Perimeter() {
        return 2 * (a + b);
    }

    //получение сторон прямоугольника
    public int getSide1() {
        return a;
    }

    public int getSide2() {
        return b;
    }
}
