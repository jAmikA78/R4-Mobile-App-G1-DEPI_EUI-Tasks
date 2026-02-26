/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab3task;

/**
 *
 * @author Zeyad
 */
public class Lab3Task {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(2,4);
        Circle cir = new Circle(3);
        Triangle tri = new Triangle(5);
        
        System.out.println("Sum of the areas of the three shapes is: " );
        System.out.println(Picture.sumAreas(rect,cir,tri));
    }
}
