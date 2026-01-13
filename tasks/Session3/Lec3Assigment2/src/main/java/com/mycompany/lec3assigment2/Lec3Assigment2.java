
package com.mycompany.lec3assigment2;


public class Lec3Assigment2 {

    public static void main(String[] args) {
        
        Parent p = new Parent();
        Child c = new Child ();
        c.setNum1(2);
        c.setNum2(3);
        c.setNum3(4);
        
        System.out.print("Child sum = ");
        System.out.println(c.sum());
    }
    
}
