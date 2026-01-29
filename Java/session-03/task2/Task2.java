/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mohammedtaysser
 */
public class Task2 {
    public static void main (String[] args){
        Child c = new Child();
        c.setNum1(10);
        c.setNum2(20);
        c.setNum3(30);
        System.out.println("Sum = " + c.Sum());
    }
}


class Parent{
    protected int num1;
    protected int num2;
    
    public void setNum1(int num1){
        this.num1 = num1;
    }
    
    public int getNum1(){
        return num1;
    }
    
    public void setNum2(int num2){
        this.num2 = num2;
    }
    
    public int getNum2(){
        return num2;
    }
    
    public int Sum(){
        return num1 + num2;
    }
}


class Child extends Parent{
    protected int num3;
    
    public void setNum3(int num3){
        this.num3 = num3;
    }
    
    public int getNum3(){
        return num3;
    }
    
    @Override
    public int Sum(){
        return num1 + num2 + num3;
    }
}