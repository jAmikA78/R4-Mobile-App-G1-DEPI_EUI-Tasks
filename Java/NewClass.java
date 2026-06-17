package project;
 
abstract class Shape {
    protected double dim;

    public Shape(double dim) {
        this.dim = dim;
    }

    public abstract double calculateArea();
}

class Rectangle extends Shape {
    private double width;

    public Rectangle(double length, double width) {
        super(length);
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return dim * width;
    }
}

class Triangle extends Shape {
    private double height;

    public Triangle(double base, double height) {
        super(base);
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * dim * height;
    }
}

class Circle extends Shape {

    public Circle(double radius) {
        super(radius);
    }

    @Override
    public double calculateArea() {
        return Math.PI * dim * dim;
    }
}

class Picture {

    public double sumAreas(Shape s1, Shape s2, Shape s3) {
        return s1.calculateArea() +
               s2.calculateArea() +
               s3.calculateArea();
    }
}


public class NewClass {
    
    public static void main(String[]args){
    
         Shape r = new Rectangle(5, 4);
        Shape t = new Triangle(6, 3);
        Shape c = new Circle(2);

        Picture p = new Picture();
        double totalArea = p.sumAreas(r, t, c);

        System.out.println("Total Area = " + totalArea);
}
    
    
}