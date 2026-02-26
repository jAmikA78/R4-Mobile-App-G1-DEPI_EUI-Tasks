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
public class evenChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a nubmer to check if it's even: ");
        
        int n = input.nextInt();
        
        if (n%2 == 0){
            System.out.println("the number is even");
        }else{
            System.out.println("the number is odd");
        }
    }
}
