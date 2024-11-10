package figures;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(8, "Blue", "Red"));
        shapes.add(new Rectangle(3, 6, "Black", "White"));
        shapes.add(new Triangle(3, 9, 7, "Green", "Yellow"));

        for (Shape shape : shapes) {
            shape.info();
        }
    }
}