package figures;

public class Rectangle extends Shape {

    static private final String TITLE = "Rectangle";
    private int sideA;
    private int sideB;

    public Rectangle(int sideA, int sideB, String colorFill, String colorBorder) {
        super(TITLE, colorFill, colorBorder);
        this.sideA = sideA;
        this.sideB = sideB;
        perimeter = getPerimeter(sideA, sideB);
        area = getArea(sideA, sideB);
    }
}