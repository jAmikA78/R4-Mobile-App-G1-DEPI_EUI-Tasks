
package com.mycompany.shape;


public class Rectangle extends Shape {
   int lenght;

 public Rectangle(int dim , int lenght){
       super(dim);
       this.lenght = lenght ;
       
   }
   //lenght * width(dim)
    @Override
    public int calculateArea() {
      
       return dim * lenght ;
       
    }
    
    
    

    
     
     
 
   
    
}      
    
    
    
    

