package figures;

public interface Calculation {

    //Периметр круга
    default double getPerimeter(int radius) {
        final double PI = Math.PI;
        return 2 * PI * radius;
    }

    //Периметр прямоугольника
    default double getPerimeter(int sideA, int sideB) {
        return 2 * (sideA + sideB);
    }

    //Периметр треугольника
    default double getPerimeter(int sideA, int sideB, int sideC) {
        return sideA + sideB + sideC;
    }

    //Площадь круга
    default double getArea(int radius) {
        final double PI = Math.PI;
        return PI * radius * radius;
    }

    //Площадь прямоугольника
    default double getArea(int sideA, int sideB) {
        return sideA * sideB;
    }

    //Площадь треугольника
    default double getArea(int sideA, int sideB, int sideC) {
        double p = (double) (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
}
