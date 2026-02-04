package com.mycompany.shape;


public class Circle extends Shape {
    
    

    public Circle(int dim) {
        super(dim);
    }

    @Override
    public int calculateArea() {
        return (int) (Math.PI * (double)dim * (double)dim)  ; //type casting
    }
    
    
}
