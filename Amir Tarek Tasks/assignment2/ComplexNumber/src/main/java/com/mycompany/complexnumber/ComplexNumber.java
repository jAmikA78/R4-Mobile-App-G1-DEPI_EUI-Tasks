/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.complexnumber;


/**
 *
 * @author Amir Fahmy 7
 */
class ComplexNum{
private int real , imagine;
        
public  ComplexNum(int real,int imagine){
this.real=real;
this.imagine=imagine;
}

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImagine() {
        return imagine;
    }

    public void setImagine(int imagine) {
        this.imagine = imagine;
    }

public static ComplexNum add(ComplexNum c1,ComplexNum c2){
ComplexNum c3=new ComplexNum(c1.real+c2.real,c1.imagine+c2.imagine);
return c3;
}

public static ComplexNum subtract(ComplexNum c1,ComplexNum c2){
ComplexNum c3=new ComplexNum(c1.real-c2.real,c1.imagine-c2.imagine);
return c3;
}
 public void print(){
     if(imagine>0)
     System.out.println(real+" + "+imagine+"i");
     else if (imagine<0)
              System.out.println(real+" - "+imagine+"i");
     else 
         System.out.println(real);
  }

}

public class ComplexNumber {
   
    public static void main(String[] args) {
ComplexNum c1= new ComplexNum(1,3);
c1.print();
ComplexNum c2= new ComplexNum(2,4);
        ComplexNum.add(c1, c2).print();

    }
}
