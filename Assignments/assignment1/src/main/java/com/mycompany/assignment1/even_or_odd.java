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

public class even_or_odd {

    public static void checkNumber() {

        System.out.print("enter a number: ");
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();

        if (num % 2 == 0) {
            System.out.println("number is even");
        } else {
            System.out.println("number is odd");
        }
    }
}

