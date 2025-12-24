/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment1;

import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class IpChecker {
        public static void checkIP() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter IP Address: ");
        String ip = input.nextLine();
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            System.out.println("Invalid IP: must contain 4 parts.");
        }else{
            for (int i = 0; i <4; i++) {
            try {
                int num = Integer.parseInt(parts[i]);
                if (num< 0 || num > 255) {
                    System.out.println("Invalid IP: part " + (i + 1) + " is out of range.");
                    return;
                }
                System.out.println("Part " + (i + 1) + " = " + num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid IP: part " + (i + 1) + " is not a number.");
                return;
            }
        }

        }

        
    }
    
}
