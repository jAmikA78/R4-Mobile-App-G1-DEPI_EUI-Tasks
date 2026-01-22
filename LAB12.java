 

package com.mycompany.lab12;

 import java.util.Scanner;
public class LAB12 {

    public static void main(String[] args) {
      Scanner input=new Scanner(System.in);
      System.out.print("Enter a num:");
       int num = input.nextInt();
    /*  if(num%2==0){
           System.out.print( num+"is even");
       }
       else{
            System.out.print( num+"is odd");
       }*/
     String result=(num%2==0)?"even":"odd";
     System.out.print(num+" is "+result);
    

    }
}
