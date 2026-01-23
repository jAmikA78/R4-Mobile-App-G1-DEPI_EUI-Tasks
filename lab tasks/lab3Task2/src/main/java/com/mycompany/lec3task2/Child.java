/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lec3task2;

/**
 *
 * @author Zeyad
 */
public class Child extends Parent{
    protected int n3;
    
    public Child(int n1, int n2, int n3){
        super(n1,n2);
        this.n3 = n3;
    }

    public int getN3() {
        return n3;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }
    
    @Override
    public int sum(){
        return super.sum() + n3;
    }
}
