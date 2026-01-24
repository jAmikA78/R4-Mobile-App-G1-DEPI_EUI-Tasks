/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.evenorodd;
import java.util.Scanner;
/**
 *
 * @author Amir Fahmy 7
 */
public class EvenOrOdd {

    public static void main(String[] args) {
Scanner in=new Scanner (System.in);
        System.out.println("Enter Number:");
int num =in.nextInt();

if (num%2==0)
            System.out.println("Number is Even");
else
            System.out.println("Number is Odd");
    }
}
