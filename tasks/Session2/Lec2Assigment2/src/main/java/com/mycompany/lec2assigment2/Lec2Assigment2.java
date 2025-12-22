
package com.mycompany.lec2assigment2;

public class Lec2Assigment2 {

    public static void main(String[] args) {
     ComplexNum c1 = new ComplexNum(2,2);
     ComplexNum c2 = new ComplexNum(1,5);
     
     ComplexNum sum = c1.add(c2);
     ComplexNum sub = c1.sub(c2);
     

     System.out.print("THE SUM IS : ");  //3+7i
     sum.print();
     System.out.print("THE SUB IS : ");  //1-3i
     sub.print();
 
        
    }
}
