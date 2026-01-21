

package com.mycompany.shape;


public abstract class Shape {
  
  protected int dim;
 
 public Shape(int dim){
      this.dim = dim ;
  }
  
  
  void setDim (int dim){
      this.dim = dim ;
  }
  
  public int getDim(int dim){
      return dim ;
      
  }

  

   
  public abstract int calculateArea();
        
      
        
        
        
    
}
