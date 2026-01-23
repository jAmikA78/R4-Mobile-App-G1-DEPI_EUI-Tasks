/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1task;

import java.util.Scanner;

/**
 *
 * @author Zeyad
 */
public class IPDivider {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the IP adress: ");
        String IP = new String();
        IP = input.nextLine();
       
        String[] parts = IP.split("\\.");
        
        for(String s : parts){
            System.out.println(s);
        }
    }
}
