/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment2;

/**
 *
 * @author Hp
 */
public class ComplexNumber {
    
    private int real;
    private int imaginary;

    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber newOne) {
        int newReal = this.real + newOne.getReal();
        int newImaginary = this.imaginary + newOne.getImaginary();
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        int newReal = this.real - other.getReal();
        int newImaginary = this.imaginary - other.getImaginary();
        return new ComplexNumber(newReal, newImaginary);
    }

    public void printComplex() {
        if(imaginary >= 0)
            System.out.println(real + " + " + imaginary + "i");
        else
            System.out.println(real + " - " + (-imaginary) + "i");
    }

    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(5, -6);
        ComplexNumber c2 = new ComplexNumber(3, 2);

        System.out.print("First complex number: ");
        c1.printComplex();

        System.out.print("Second complex number: ");
        c2.printComplex();

        ComplexNumber sum = c1.add(c2);
        System.out.print("Sum: ");
        sum.printComplex();

        ComplexNumber difference = c1.subtract(c2);
        System.out.print("Difference: ");
        difference.printComplex();
    }
}
