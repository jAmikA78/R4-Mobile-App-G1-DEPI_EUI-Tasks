/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.shapeclass;
/**
 *
 * @author Amir Fahmy 7
 */
abstract class Shape{

    public Shape(double dim) {
        this.dim = dim;
    }
    
     protected double dim;
    public abstract double calculateArea();
}

class Rectangle extends Shape{
    private double legnth;

    public Rectangle(double dim,double legnth) {
        super(dim);
        this.legnth = legnth;
    }

    
    
public double calculateArea(){
return (this.dim+this.legnth)*2;
}

}

class Triangle extends Shape{
    private double hight;
    public Triangle(double dim,double hight){
    super(dim);
    this.hight=hight;
    }
    public double calculateArea(){
return 0.5*(this.dim*this.hight);
}
}

class Circle extends Shape{
public Circle(double dim){
super(dim);
}
    public double calculateArea(){
return (this.dim*this.dim*Math.PI);
  }
}

class Picture{
public double sumAreas(Shape s1,Shape s2,Shape s3){
return (s1.calculateArea()+s2.calculateArea()+s3.calculateArea());
}
}
public class ShapeClass {

    public static void main(String[] args) {
        Shape s1=new Circle(5);
        Shape s2=new Triangle(5,10);
        Shape s3=new Rectangle(7,12);
        Picture p1=new Picture();
        System.out.println(p1.sumAreas(s1, s2, s3));
    }
}
