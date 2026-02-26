/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3task;

/**
 *
 * @author Zeyad
 */
public class Rectangle extends Shape{
    private double height;
    
    public Rectangle(double h, double w){
        super(w);
        height = h;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public double calculateArea(){
        return dim*height;
    }
}