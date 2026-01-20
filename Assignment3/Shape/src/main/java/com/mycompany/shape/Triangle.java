
package com.mycompany.shape;

public class Triangle extends Shape {
    int height;

    public Triangle(int dim , int height) {   //base*height
        super(dim);
        this.height = height ;
    }

    @Override
    public int calculateArea() {
       
       return dim * height ;
    }
    
    
    
    
   
    
    
}
