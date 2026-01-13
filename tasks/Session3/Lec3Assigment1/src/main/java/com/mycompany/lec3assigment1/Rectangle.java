
package com.mycompany.lec3assigment1;

public class Rectangle extends Shape { 
    private int width;
     
    public Rectangle(int width, int dim) {
        super(dim);
        this.width = width;
    }
    
      public double calculateArea( ){
         return width * dim ;
     }
    
}
