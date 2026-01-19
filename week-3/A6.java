

public class A6 {
    public static void main(String[] args) {
        rectangle re = new rectangle(4,8);
        triangle tri = new triangle(4,8);
        circle cir = new circle(7);
        picture pic= new picture(tri,re,cir);

        System.out.println(pic.sumAreas());
    }
}

abstract class shape{
    double dim;

    abstract double calculateArea();
}

class rectangle extends shape{
    double wid;

    rectangle(double wid,double dim){
        this.wid=wid;
        this.dim=dim;
    }

    rectangle(){
        this.wid=0;
        this.dim=0;
    }

    double calculateArea() {
        return dim*wid;
    }
}

class triangle extends shape{
    double wid;
    triangle(double wid,double dim){
        this.dim=dim;
        this.wid=wid;
    }
    triangle(){
        this.dim=0;
        this.wid=0;
    }
    double calculateArea() {
        return 0.5*dim*wid;
    }
}

class circle extends shape{
    circle(int r){
        dim=r;
    }
    circle(){
        dim=0;
    }

    double calculateArea() {
        return 3.14*Math.pow(dim,2);
    }
}

class picture{
    double t,r,c;
    picture(triangle tri,rectangle rect, circle circ){
        t=tri.calculateArea();
        r=rect.calculateArea();
        c=circ.calculateArea();
    }
    public double sumAreas(){
        return t+r+c;
    }
}
