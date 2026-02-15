

public class A6 {
    public static void main(String[] args) {
        Rectangle re = new Rectangle(4,8);
        Triangle tri = new Triangle(4,8);
        Circle cir = new Circle(7);
        Picture pic= new Picture(tri,re,cir);

        System.out.println(pic.sumAreas());
    }
}

abstract class Shape{
    protected double dim = 0;

    public void set_dim(double d){
    	if(d >= 0){
		dim = d;
	}
    }
    public double get_dim(){
    	return dim;
    }

    abstract double calculateArea();
}

class Rectangle extends Shape{
    double wid = 0;

    Rectangle(double wid,double dim){
        this.wid=wid;
        set_dim(dim);
    }

    Rectangle(){
    }

    @Override
    double calculateArea() {
        return get_dim()*wid;
    }
}

class Triangle extends Shape{
    double wid = 0;

    Triangle(double wid,double dim){
        set_dim(dim);
        this.wid=wid;
    }
    Triangle(){
    }

    @Override
    double calculateArea() {
        return 0.5*get_dim()*wid;
    }
}

class Circle extends Shape{
    Circle(int r){
        set_dim(r);
    }
    Circle(){
    }

    @Override
    double calculateArea() {
        return 3.14*Math.pow(get_dim(),2);
    }
}

class Picture{
    double t,r,c;
    Picture(Shape tri,Shape rect,Shape circ){
        t=tri.calculateArea();
        r=rect.calculateArea();
        c=circ.calculateArea();
    }
    public double sumAreas(){
        return t+r+c;
    }
}
