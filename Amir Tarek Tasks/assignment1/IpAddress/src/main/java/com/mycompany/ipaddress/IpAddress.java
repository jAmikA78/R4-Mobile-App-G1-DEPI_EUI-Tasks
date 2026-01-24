/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ipaddress;

import java.util.Scanner;

/**
 *
 * @author Amir Fahmy 7
 */
public class IpAddress {

    public static void main(String[] args) {
Scanner in = new Scanner(System.in);
        System.out.println("Enter Ip Address");
        String s = in.nextLine();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '.'){
                System.out.println();
            }else{
                System.out.print(s.charAt(i));
            }
        }
             
    }
}
