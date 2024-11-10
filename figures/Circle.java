package figures;

public class Circle extends Shape {

    static private final String TITLE = "Circle";
    private int radius;

    public Circle(int radius, String colorFill, String colorBorder) {
        super(TITLE, colorFill, colorBorder);
        this.radius = radius;
        perimeter = getPerimeter(radius);
        area = getArea(radius);
    }
}