/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mohammedtaysser
 */

public class Task1 {
    public static void main(String[] args){
        Rectangle rect = new Rectangle();
        Triangle tri = new Triangle();
        Circle cir = new Circle();
        Picture pic = new Picture();
        rect.setDim(30.0);
        rect.setWidth(20.0);
        rect.calcArea();
        tri.setDim(20.0);
        tri.setHeight(10.0);
        tri.calcArea();
        cir.setDim(20.0);
        cir.calcArea();
        System.out.println("Sum Of Area= " + pic.sumAreas(rect, tri, cir));
    }
}

abstract class Shape{
    protected double dim;
    public abstract double calcArea();
    public void setDim(double dim){
        this.dim = dim;
    }
    public double getDim(){
        return dim;
    }
}

class Rectangle extends Shape{
    private double width;
    public void setWidth(double width){
        this.width = width;
    }
    @Override
    public double calcArea(){
        return dim * width;
    }
}

class Triangle extends Shape{
    private double height;
    public void setHeight(double height){
        this.height = height;
    }
    @Override
    public double calcArea(){
        return 0.5 * dim * height;
    }
}

class Circle extends Shape{
    @Override
    public double calcArea(){
        return 2 * 3.14 * dim;
    }
}

class Picture{
    public double sumAreas(Shape sh1, Shape sh2, Shape sh3){
        return sh1.calcArea() + sh2.calcArea() + sh3.calcArea();
    }
}