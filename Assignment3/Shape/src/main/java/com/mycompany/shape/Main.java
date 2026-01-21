
package com.mycompany.shape;


public class Main {
    public static void main(String[] args) {
        
      
        Rectangle rec = new Rectangle(5,6);    //rectangle
        rec.calculateArea();
         System.out.println("the area of rectangle is :" + rec.calculateArea() + "cm" );
        
      
        Triangle tri = new Triangle(13,20);    //triangle
        tri.calculateArea();
          System.out.println("the area of triangle is :" + tri.calculateArea() + "cm" );
        
        Circle circ = new Circle(20); 
        circ.calculateArea();
          System.out.println("the area of Circle is :" + circ.calculateArea() + "cm" );
        
          
          Picture pic = new Picture ();
          pic.sumOfAreas(rec,tri,circ);
           System.out.println("the sum of areas is :" + pic.sumOfAreas(rec, tri, circ) + "cm" );
    }
}
