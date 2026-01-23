
package com.mycompany.lab2task;


public class Complex {
    private int real;
    private int img;

    public Complex(){}
    
    public Complex(int r, int i){
        real = r;
        img = i;
    }
    
    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
    
    public static Complex add(Complex c1, Complex c2){
        Complex result = new Complex(c1.real + c2.real, c1.img + c2.img);
        return result;
    }
    
    public static Complex subtract(Complex c1, Complex c2){
        Complex result = new Complex(c1.real - c2.real, c1.img - c2.img);
        return result;
    }
    
    public void print(){
        if(img == 0){
            System.out.println(real);
        }else if(real == 0){
            System.out.println(img + "i");
        }else{
            System.out.println(real + " " + ((img < 0) ? "" : "+") + img + "i");
        }
    }
    
}   
