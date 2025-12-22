
package com.mycompany.lec3assigment1;

public abstract class Shape {
    
   protected int dim;

    public Shape(int dim) {
        this.dim = dim;
    }
    
     public abstract double calculateArea();
     
}
