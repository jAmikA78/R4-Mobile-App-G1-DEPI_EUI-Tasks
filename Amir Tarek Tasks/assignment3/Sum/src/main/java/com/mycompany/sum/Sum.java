/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sum;
/**
 *
 * @author Amir Fahmy 7
 */
class Sum2{
protected int num1;
protected int num2;

    public Sum2(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

public int sum(){
return num1+num2;
  }
}
class Sum3 extends Sum2{
private int num3;
public Sum3(int num1,int num2,int num3){
super(num1,num2);
this.num3=num3;
 } 
public int sum(){
return super.sum()+num3;
  }
}
public class Sum {

    public static void main(String[] args) {
Sum2 s1=new Sum2(4,3);
        System.out.println(s1.sum());

        Sum3 s2=new Sum3(1,2,4);
        System.out.println(s2.sum());
    }
}
