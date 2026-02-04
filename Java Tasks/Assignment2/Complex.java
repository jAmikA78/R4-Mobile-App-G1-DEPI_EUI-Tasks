package com.mycompany.assignment2;


public class Complex {

  double real ;
  double img;


  Complex(double real, double img){
      this.real=real;
      this.img = img;

  }

  public void add(double real2 , double img2){
      this.real = this.real + real2 ;
      this.img = this.img + img2 ;
  }
    public void printsum() {
        System.out.println("the result is:"+this.real + " + " +this.img + "i");


    }

  public void subtract(double real2, double img2){
     this.real = this.real - real2 ;
     this.img = this.img - img2 ;
  }
    public void printsub() {
        System.out.println("the result is:"+this.real + " - " +this.img + "i");


    }





}