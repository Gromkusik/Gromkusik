public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle("green", "red", 99);
        Rectangle rectangle1 = new Rectangle("purple", "white", 13, 15);
        Triangle triangle1 = new Triangle("black", "pink", 13, 14, 12);

        System.out.println("\nПлощадь круга: " + circle1.Square());
        System.out.println("Длина окружности круга: " + circle1.Perimeter());

        System.out.println("\nПлощадь прямоугольника: " + rectangle1.Square());
        System.out.println("Периметр прямоугольника: " + rectangle1.Perimeter());

        System.out.println("\nПлощадь треугольника: " + triangle1.Square());
        System.out.println("Периметр треугольника: " + triangle1.Perimeter() + "\n");

        circle1.setFillingColor("violet");
        circle1.setOutlineColor("green");
        rectangle1.setFillingColor("gray");
        rectangle1.setOutlineColor("beige");
        triangle1.setFillingColor("yellow");
        triangle1.setOutlineColor("orange");

        circle1.info();
        rectangle1.info();
        triangle1.info();

        circle1.setRadius(77);
        circle1.info();
    }
}