/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ipaddress;

/**
 *
 * @author Heba
 */
public class IPaddress{

    public static void main(String[] args) {

        String ip = "163.121.12.30";
        String part = "";

        for (int i = 0; i < ip.length(); i++) {
            char ch = ip.charAt(i);
            if (ch == '.') {
                System.out.println(part);  
                part = "";
            } else {
                part = part + ch; 
            }}

        System.out.println(part);}}
    

