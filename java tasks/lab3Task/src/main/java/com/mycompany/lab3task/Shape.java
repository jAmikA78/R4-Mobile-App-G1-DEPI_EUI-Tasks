/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3task;


public abstract class Shape {
    protected double dim;
    
    public Shape(double d){
        dim = d;
    }

    public double getDim() {
        return dim;
    }

    public void setDim(double dim) {
        if(dim >= 0){
            this.dim = dim;
        }else {
            System.out.println("Dimension can't be negative!!!");
        }
    }
    
    abstract double calculateArea();
}

