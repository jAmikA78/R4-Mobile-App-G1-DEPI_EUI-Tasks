
package com.mycompany.lec3assigment1;


public class Circle extends Shape {

    public Circle(int dim) {
        super(dim);
    }
    
    public double calculateArea(){
      return  Math.PI * dim * dim;
    }
    
}
