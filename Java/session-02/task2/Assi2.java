/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mohammedtaysser
 */
public class Assi2 {
    public static void main(String[] args){
        Complex c1 = new Complex(1,1,5,6);
        c1.Sum();
        System.out.println("Sum: ");
        c1.print();
        c1.Substract();
        System.out.println("Substraction: ");
        c1.print();
    }
}
class Complex{
    private int real_1;
    private int imaginary_1;
    private int real_2;
    private int imaginary_2;
    private int real;
    private int imaginary;
    public Complex(int real_1, int imaginary_1, int real_2, int imaginary_2){
        this.real_1 = real_1;
        this.imaginary_1 = imaginary_1;
        this.real_2 = real_2;
        this.imaginary_2 = imaginary_2;
    }
    public void Sum(){
        real = real_1 + real_2;
        imaginary = imaginary_1 + imaginary_2;
    }
    public void Substract(){
        real = real_1 - real_2;
        imaginary = imaginary_1 - imaginary_2;
    }
    public void print(){
        if (imaginary == 0){
            System.out.println(real);
        }
        else if (real == 0){
            System.out.println(imaginary + "i");
        }
        else if (imaginary > 0){
            System.out.println(real + " + " + imaginary + "i");
        }
        else{
            System.out.println(real + "" + imaginary + "i");
        }
    }
}
