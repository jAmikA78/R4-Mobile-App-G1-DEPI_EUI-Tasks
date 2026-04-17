
    public class assi3{
    public static abstract class Shape{
        protected double dim;
    
        public Shape(double d){
            
            this.dim=d;


        }
        public abstract double calculateArea();

    }


    public static class Rectangle extends Shape{
        protected double width;
        public Rectangle(double height, double width){
            super(height);
            this.width=width;


        }


        @Override
        public double calculateArea(){

            return dim * width; 
        }

    }

    public static class Circle extends Shape{

        public Circle(double radius){

            super(radius);
        }


        @Override
        public double calculateArea(){
            return Math.PI * dim * dim;
        }


    }

    public static class Triangle extends Shape{
        protected double base;

        public Triangle(double base, double height){
            super (height);
            this.base=base;
        }

        @Override
        public double calculateArea(){
            return 0.5 * base * dim;
        }

    }
public static class Totsum {
        protected double num1, num2;

      
        public Totsum(double n1, double n2) { 
            this.num1 = n1;
            this.num2 = n2;
        }

      
        public double sum() {
            return num1 + num2;
        }
    }

    public static class Child extends Totsum {
        protected double num3;

      
        public Child(double n1, double n2, double n3) {
          
            super(n1, n2); 
            this.num3 = n3;
        }

        @Override
        public double sum() {
            return num1 + num2 + num3;
        }
    }


    public static void main(String[] args) {
        Shape r = new Rectangle(10, 5);
        Shape c = new Circle(7);
        Shape t = new Triangle(10, 5);
        Totsum a=new Child(5 , 4, 3);






        System.out.println("Rectangle Area: " + r.calculateArea());
        System.out.println("Circle Area: " + c.calculateArea());
        System.out.println("Triangle Area: " + t.calculateArea());
    }
}