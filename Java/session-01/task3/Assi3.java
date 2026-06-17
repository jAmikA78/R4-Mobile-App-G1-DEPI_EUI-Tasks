/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mohammedtaysser
 */
import java.util.Scanner;
public class Assi3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an IP address: ");
        String ipAddress = scanner.nextLine();
       
        String[] parts = ipAddress.split("\\.");
        
        if (parts.length != 4) {
            System.out.println("Invalid");
            return;
        }
        
        boolean isValid = true;
        
        for(int i = 0; i < parts.length; i++){
            int num = Integer.parseInt(parts[i]);
            if (num < 0 || num > 255) {
                    System.out.println("Invalid!");
                    return;
                }
        }   
        if(isValid){
          for(String part : parts){
              System.out.println(part);
          }
        } 
        else {
          System.out.println("Invalid");
        }
        
    }
    }