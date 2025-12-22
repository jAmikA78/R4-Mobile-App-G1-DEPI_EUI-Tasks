
package com.mycompany.lec2assigment2;


public class ComplexNum {
    private int real ;
    private int img ;

    
    public ComplexNum(int real, int img) {
        this.real = real;
        this.img = img;
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
    
    public ComplexNum add (ComplexNum x){
        ComplexNum addResult = new ComplexNum(this.real + x.real ,this.img + x.img);
        
        return addResult ;
    }
    public ComplexNum sub (ComplexNum x){
     ComplexNum subResult = new ComplexNum(this.real - x.real ,this.img - x.img);
        
        return subResult ;
    }
    
    
    public void print(){
        if (this.img >0)
            System.out.println(this.real +"+"+this.img +"i");
        else if (this.img <0)
            System.out.println(this.real +""+ this.img + "i");
        else
            System.out.println(this.real);
            
    }
        
    
}
