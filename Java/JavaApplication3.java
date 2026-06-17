
package javaapplication3;
import java.util.Scanner;
public class JavaApplication3 {


    public static void main(String[] args) {
        
        System.out.println("Inset the number to check : ");
        
    Scanner input=new Scanner(System.in);
    
    int c=input.nextInt();
    
    if (c%2==0)
    {System.out.println("the number is even");}
    else 
            System.out.println("The number is odd");
       
    }
    
}
