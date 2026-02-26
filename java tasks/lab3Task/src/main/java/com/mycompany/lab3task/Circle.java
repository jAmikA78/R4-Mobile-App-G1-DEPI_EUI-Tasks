/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3task;

/**
 *
 * @author Zeyad
 */
public class Circle extends Shape{
    public Circle(double radius){
        super(radius);
    }
    
    @Override
    public double calculateArea(){
        return dim*dim*3.14;
    }
}
