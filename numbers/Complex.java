package com.mycompany.numbers;

public class Complex {
    private int real; 
    private int img;
    public Complex(int r,int i){ 
        real =r;
   img =i;}
  public void setImg(int img) {
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getReal() {
        return real;
    }
  public Complex add(Complex c){
      int r =this.real + c.real;
      int i =this.img + c.img;
return new Complex(r,i);} 
  public Complex subtract(Complex c){
    int r =this.real - c.real;
      int i =this.img - c.img;  
      return new Complex(r,i);
  }
  public void print (){
  System.out.println(real + ""+ img);
  }
}
