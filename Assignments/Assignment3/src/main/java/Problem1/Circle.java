/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problem1;

/**
 *
 * @author Hp
 */
public class Circle extends Shape{
        public Circle(double radius) {
        super(radius);
    }

    @Override
    public double calculateArea() {
        return Math.PI * dim * dim;
    }
}
