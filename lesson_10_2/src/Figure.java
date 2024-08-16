public abstract class Figure implements formulas {
    private String fillingColor = "222";
    private String outlineColor = "111";

    public Figure(String Color1, String Color2) {
        fillingColor = Color1;
        outlineColor = Color2;
    }

    public void setFillingColor(String color) {
        fillingColor = color;
        System.out.println("Цвет заливки изменен на " + this.fillingColor);
    }

    public void setOutlineColor(String color) {
        outlineColor = color;
        System.out.println("Цвет границ изменен на " + this.outlineColor);
    }

    public String getFillingColor() {
        return fillingColor;
    }

    public String getOutlineColor() {
        return outlineColor;
    }
}
