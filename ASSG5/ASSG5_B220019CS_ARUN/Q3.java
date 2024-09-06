import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String shapeName = sc.nextLine();  
        double value = sc.nextDouble();    

        ShapeArea shape;

        if (shapeName.equalsIgnoreCase("Circle")) {
            shape = new Circle();
        } else if (shapeName.equalsIgnoreCase("Square")) {
            shape = new Square();
        } else {
            System.out.println("Invalid shape");
            sc.close();
            return;
        }

        System.out.println((int) shape.area(value));

        sc.close();
    }
}

interface ShapeArea {
    double area(double value);
}

class Circle implements ShapeArea {
    private static final double PI = 3.14;

    @Override
    public double area(double radius) {
        return PI * radius * radius;
    }
}

class Square implements ShapeArea {

    @Override
    public double area(double side) {
        return side * side;
    }
}
