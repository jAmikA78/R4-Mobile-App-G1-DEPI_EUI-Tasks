
package com.mycompany.assigment2;
import java.util.Scanner;


public class Assigment2 {

    public static void main(String[] args) {
        
        Assigment2 obj1 = new Assigment2();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter The Number: ");
        obj1.CheckEeven(input.nextInt());
       
    }
    void  CheckEeven(int x){
        if(x%2 ==0)
            System.out.println("The Num is Even");
        else
            System.out.println("The Num is Odd");
   }
}

