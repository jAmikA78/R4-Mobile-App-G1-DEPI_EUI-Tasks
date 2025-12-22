
package com.mycompany.lec3assigment2;

public class Parent {
    protected int num1;
    protected int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
    
    
    public int sum(){
        
       return num1 + num2;
    }
}
