/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problem2;

/**
 *
 * @author Hp
 */
public class Child extends Parent{
    private int num3;
    public Child(int num1, int num2, int num3) {
        super(num1, num2); 
        this.num3 = num3;
    }
    @Override
    public int sum() {
        return num1 + num2 + num3;
    }
}
