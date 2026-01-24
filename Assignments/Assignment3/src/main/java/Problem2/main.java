/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problem2;

/**
 *
 * @author Hp
 */
public class main {

    public static void main(String[] args) {
        Parent p = new Parent(5, 10);
        System.out.println("Sum from Parent: " + p.sum());

        Child c = new Child(5, 10, 15);
        System.out.println("Sum from Child: " + c.sum());
    }
}

