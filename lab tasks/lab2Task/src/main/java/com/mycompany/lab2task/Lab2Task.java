/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab2task;

import java.util.Scanner;

/**
 *
 * @author Zeyad
 */
public class Lab2Task {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1. create and print student");
        System.out.println("2. create and print complex");
        
        int n = input.nextInt();
        if (n == 1){
            Student std = new Student("Zeyad Ahemd", 20, 22002);
            std.printInfo();
        }else if (n == 2) {
            Complex c1 = new Complex(7,3);
            Complex c2 = new Complex(7,4);
            
            System.out.println("c1: " );
            c1.print();
            
            System.out.println("\nc2: ");
            c2.print();
            
            System.out.println("addition: ");
            Complex.add(c1, c2).print();
            
            System.out.println("subtraction: ");
            Complex.subtract(c1, c2).print();
        }
    }
}
