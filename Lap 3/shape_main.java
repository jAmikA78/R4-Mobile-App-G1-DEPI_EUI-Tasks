abstract class Shape {
    double dim;

    Shape(double dim) {
        this.dim = dim;
    }

    abstract double calculateArea();
}

class Rectangle extends Shape {
    double width;

    Rectangle(double length, double width) {
        super(length); 
        this.width = width;
    }

    @Override
    double calculateArea() {
        return dim * width;
    }
}

class Circle extends Shape {

    Circle(double radius) {
        super(radius); 
    }

    @Override
    double calculateArea() {
        return Math.PI * dim * dim;
    }
}

class Triangle extends Shape {
    double height;

    Triangle(double base, double height) {
        super(base); 
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * dim * height;
    }
}

class Picture {

    double sumAreas(Shape s1, Shape s2, Shape s3) {
        return s1.calculateArea() +
               s2.calculateArea() +
               s3.calculateArea();
    }
}

public class shape_main {
    public static void main(String[] args) {

        Shape r = new Rectangle(1, 2);
        Shape t = new Triangle(3, 4);
        Shape c = new Circle(5);

        Picture pic = new Picture();
        double totalArea = pic.sumAreas(r, t, c);

        System.out.println("Total Area = " + totalArea);
    }
}
