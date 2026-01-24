/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problem1;

/**
 *
 * @author Hp
 */
public class Rectangle extends Shape{
       
    private double height; 
    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Height must be positive");
        }
    }
    public Rectangle(double width, double height) {
        super(width);
        setHeight(height);
    }
    @Override
    public double calculateArea() {
        return dim * height;
    }
    
}
