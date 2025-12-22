
package com.mycompany.eui;
import java.util.Scanner;

public class EvenOdd {
    public static void main(String args[]){
             
        Scanner input= new Scanner(System.in);
        System.out.println("enter the number:");
        
        int num;
        num = input.nextInt();
        input.close();
         
        if (num%2==0){
            System.out.println("the number is even");
        }
        else{
            System.out.println("the number is odd");
        }
                
    
    }
    
    
}
