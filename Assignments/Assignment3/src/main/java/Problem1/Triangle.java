/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problem1;

/**
 *
 * @author Hp
 */
public class Triangle extends Shape{
    private double height;
    
    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Height must be positive");
        }
    }

    public Triangle(double base, double height) {
        super(base);
        setHeight(height);
    }

    @Override
    public double calculateArea() {
        return 0.5 * dim * height;
    }
}
