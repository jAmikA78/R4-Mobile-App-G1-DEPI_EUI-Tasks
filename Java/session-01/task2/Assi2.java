/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mohammedtaysser
 */
import java.util.Scanner;
public class Assi2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number:");
        int number = scanner.nextInt();
        if (number % 2 == 0){
            System.out.println("Number is Even!");
        }
        else{
            System.out.println("Number is Odd!");
        }
    }

}
