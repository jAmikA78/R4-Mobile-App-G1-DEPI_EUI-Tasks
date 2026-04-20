public abstract class Shape {
    protected double dim;

    public Shape() {
    }

    public Shape(double dim) {
        this.dim = dim;
    }

    public abstract double calculateArea();

    public double getDim() {
        return dim;
    }

    public void setDim(double dim) {
        this.dim = dim;
    }
}

class Rectangle extends Shape{
    private double width;

    public Rectangle(){
    }



    public Rectangle(double dim,double width){
        super(dim);
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return dim * width;
    }

}
class Triangle extends Shape{
    private double base;

    public Triangle() {
    }

    public Triangle(double dim,double base) {
        super(dim);
        this.base = base;
    }

    @Override
    public double calculateArea() {
        return (0.5 * base) * dim;
    }
}
class Circle extends Shape{
    private final double PI = 3.14;
    public Circle() {
    }

    public Circle(double dim) {
        super(dim);
    }

    @Override
    public double calculateArea() {
        return PI * (dim * dim);
    }
}



