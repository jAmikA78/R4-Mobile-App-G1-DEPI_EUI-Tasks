
package com.mycompany.lec3assigment1;

public class Triangle extends Shape {
    private int base ;

    public Triangle(int base ,int dim) {
        super(dim);
        this.base = base;
        
    }
         
    public double calculateArea(){
        return 0.5 * base * dim;
    }
}
