package figures;

public class Triangle extends Shape {
    static private final String TITLE = "Triangle";
    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(int sideA, int sideB, int sideC, String colorFill, String colorBorder) {
        super(TITLE, colorFill, colorBorder);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        perimeter = getPerimeter(sideA, sideB, sideC);
        area = getArea(sideA, sideB, sideC);
    }
}