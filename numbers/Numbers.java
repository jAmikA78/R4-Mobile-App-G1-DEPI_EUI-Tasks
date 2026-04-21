
package com.mycompany.numbers;

public class Numbers {

    public static void main(String[] args) { 
        Complex c1 = new Complex (5,3);
    Complex c2 = new Complex (3,4);
    System.out.println("First complex number =");
    c1.print();
    System.out.println("Secont complex number =");
    c2.print();
    
    Complex sum =c1.add(c2);
    System.out.println("sum=");
    sum.print();
    Complex sub = c1.subtract(c2);
    System.out.println("Subtract=");
    sub.print();
    
    
    }}

