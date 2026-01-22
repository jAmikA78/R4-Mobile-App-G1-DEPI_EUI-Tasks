 

package com.mycompany.lab13;

 
 import java.util.Scanner;
public class LAB13 {

    public static void main(String[] args) {
       Scanner input= new Scanner(System.in);
        System.out.println(" Enter IP adress:");
        String ip=input.nextLine();
     String[] parts = ip.split("\\.");
     for(int i=0;i<parts.length;i++){
        System.out.println(parts[i]) ;
        
    }
    
}}
