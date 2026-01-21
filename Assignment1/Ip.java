
package com.mycompany.eui;

import java.util.Scanner;
public class Ip {
    public static void main ( String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the IP Adress:");
        
        String IpAdress ;
        IpAdress = input.nextLine();
        input.close();
        
        String[]parts  = IpAdress.split("\\.");
        
        for (String part : parts) {
            System.out.println(part);
        }
        
        
        
        
        
    }
    
}
