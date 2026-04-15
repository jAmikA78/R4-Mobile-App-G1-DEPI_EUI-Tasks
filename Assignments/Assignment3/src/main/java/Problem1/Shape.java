/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problem1;

/**
 *
 * @author Hp
 */
public abstract class Shape {
    protected double dim;
    public void setDim(double dim) {
        if (dim > 0) {
            this.dim = dim;
        } else {
            System.out.println("Dimention must be positive");
        }
    }
    public Shape(double dim) {
        setDim(dim);
    }
    public abstract double calculateArea();
}
