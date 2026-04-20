package com.mycompany.picture;

 abstract class Shape {
    double dim1;
    double dim2;

    Shape(double d1, double d2) {
        dim1 = d1;
        dim2 = d2;
    }

    abstract double calculateArea();
}

class Rectangle extends Shape {

    Rectangle(double width, double height) {
        super(width, height);
    }

    @Override
    double calculateArea() {
        return dim1 * dim2;
    }
}

class Triangle extends Shape {

    Triangle(double base, double height) {
        super(base, height);
    }

    @Override
    double calculateArea() {
        return 0.5 * dim1 * dim2;
    }
}

class Circle extends Shape {

    Circle(double radius) {
        super(radius, 0);
    }

    @Override
    double calculateArea() {
        return Math.PI * dim1 * dim1;
    }
}

public class Picture {

    double sumAreas(Shape s1, Shape s2, Shape s3) {
        return s1.calculateArea() + s2.calculateArea() + s3.calculateArea();
    }

    public static void main(String[] args) {
        Shape r = new Rectangle(4, 5);
        Shape t = new Triangle(3, 6);
        Shape c = new Circle(2);

        Picture pic = new Picture();
        double total = pic.sumAreas(r, t, c);

        System.out.println("Total area = " + total);
    }
}


