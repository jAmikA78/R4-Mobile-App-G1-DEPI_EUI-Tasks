/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


class Complex{
    private int real;
    private int img;
    
    public Complex(){
    real=0;
    img=0;
    }
    
    public Complex(int real,int img){
        this.real=real;
        this.img=img;
    
    }
    public int getReal(){
        return real;
    }
    
    public void setReal(int real){
        this.real=real;
    }
    public int getImg(){
        return img;
    }
    
    public void setImg(int img){
        this.img=img;
       }
    public void print(){
        if(img<0){
            System.out.println(real+" "+img+" i ");
        }else if(img==0){
            System.out.println(real);
        }else {
            System.out.println(real+" + "+img+"i");}
    }
    
    public static Complex sum(Complex c1,Complex c2){
    
    int realResult = c1.real+c2.real;
    int imgResult =c1.img+c2.img;
    Complex result =new Complex(realResult,imgResult);
    return result;
    }
     public static Complex abs(Complex c1,Complex c2){
    
    int realResult = c1.real-c2.real;
    int imgResult =c1.img-c2.img;
    Complex result =new Complex(realResult,imgResult);
    return result;
    }

}
     
public class NewClass {
    
    public static void main(String[]args){
            
            Complex n1=new Complex(2,5);
             Complex n2=new Complex();
             n2.setReal(3);
             n2.setImg(7);
             n1.print();
             n2.print();
             System.out.println("sum = ");
             Complex.sum(n1, n2).print();
             System.out.println("sub = ");
             Complex.abs(n1, n2).print();
}
}