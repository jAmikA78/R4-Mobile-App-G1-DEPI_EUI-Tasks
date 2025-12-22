
package com.mycompany.assigment3;
import java.util.Scanner;

public class Assigment3 {

    public static void main(String[] args) {
        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter The IP : ");
        String ip = input2.nextLine();
        String[] parts = ip.split("\\.");
        
        boolean isValid = true;
        if(parts.length != 4){
            System.out.println("Invalid IP Address");
            return;
        }
        for( String part :parts ){
            int a = Integer.parseInt(part);
            if(a<0 || a>255)
                isValid = false;
        }
        if(isValid){
            for(String part :parts){
                System.out.println(part);
            }
        }else{ 
            System.out.println("Invalid IP Address");
        }
    }
}
