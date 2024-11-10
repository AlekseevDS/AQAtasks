package figures;

public abstract class Shape implements Calculation {
    protected String title;
    protected double area;
    protected double perimeter;
    protected String colorFill;
    protected String colorBorder;

    public Shape(String title, String colorFill, String colorBorder) {
        this.colorFill = colorFill;
        this.colorBorder = colorBorder;
        this.title = title;
    }

    public void info() {
        System.out.println("Фигура " + title +
                " (Периметр: " + perimeter +
                ", Площадь: " + area +
                ", Цвет заливки: " + colorFill +
                ", Цвет границы: " + colorBorder + ")");
    }
}
