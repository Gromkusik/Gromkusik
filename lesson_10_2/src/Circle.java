public class Circle extends Figure {
    private int radius;

    //конструктор
    public Circle(String fillingColor, String outlineColor, int radius) {
        super(fillingColor, outlineColor);
        this.radius = radius;
    }

    //вывод инфо о фигуре
    public void info() {
        System.out.println( "\nРадиус круга: " + radius + "\n" +
                "Цвет заливки: " + this.getFillingColor() + "\n" +
                "Цвет границ: " + this.getOutlineColor() + "\n" +
                "Площадь: " + this.Square() + "\n" +
                "Длина окружности: " + this.Perimeter() + "\n");
    }

    //ФОРМУЛА ПЛОЩАДИ
    @Override
    public double Square() { //площадь круга (радиус)
            return PI * Math.pow(radius, 2);
    }

    //ФОРМУЛА ПЕРИМЕТРА
    @Override
    public double Perimeter() {
        return 2 * PI * radius;
    }

    //получение и изменение радиуса
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        System.out.println("Радиус круга изменен на " + radius);
    }
}