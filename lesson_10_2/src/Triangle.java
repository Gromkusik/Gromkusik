public class Triangle extends Figure {
    private int a, b, c;

    //конструктор
    public Triangle(String fillingColor, String outlineColor, int a, int b, int c) {
        super(fillingColor, outlineColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //вывод инфо о фигуре
    public void info() {
        System.out.println( "\nСтороны треугольника: " + this.a + "x" + this.b + "x" + this.c + "\n" +
                "Цвет заливки: " + this.getFillingColor() + "\n" +
                "Цвет границ: " + this.getOutlineColor() + "\n" +
                "Площадь: " + this.Square() + "\n" +
                "Периметр: " + this.Perimeter() + "\n");
    }

    //ФОРМУЛА ПЛОЩАДИ
    @Override
    public double Square() { //площадь круга (радиус)
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    //ФОРМУЛА ПЕРИМЕТРА
    @Override
    public double Perimeter() {
        return a + b + c;
    }

    //получение сторон треугольника
    public int getSide1() {
        return a;
    }

    public int getSide2() {
        return b;
    }

    public int getSide3() {
        return c;
    }
}