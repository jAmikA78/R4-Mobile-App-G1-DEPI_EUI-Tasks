public class Main {
    public static void main(String[] args) {

        Shape r = new Rectangle();
        r.dim = 5;
        ((Rectangle) r).w = 4;

        Shape t = new Triangle();
        t.dim = 6;
        ((Triangle) t).h = 3;

        Shape c = new Circle();
        c.dim = 5;

        Picture p = new Picture();
        System.out.println(p.sumAreas(r, t, c));
    }
}

abstract class Shape {
    double dim;
    abstract double area();
}

class Rectangle extends Shape {
    double w;
    double area() { return dim * w; }
}

class Triangle extends Shape {
    double h;
    double area() { return 0.5 * dim * h; }
}

class Circle extends Shape {
    double area() { return 3.14 * dim * dim; }
}

class Picture {
    double sumAreas(Shape a, Shape b, Shape c) {
        return a.area() + b.area() + c.area();
    }
}