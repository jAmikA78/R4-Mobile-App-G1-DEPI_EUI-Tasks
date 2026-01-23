package com.mycompany.complex;

 public class Complex {
    double real;
    double imag;

    Complex(double r, double i) {
        real = r;
        imag = i;
    }

    Complex add(Complex other) {
        double r = this.real + other.real;
        double i = this.imag + other.imag;
        return new Complex(r, i);
    }

    Complex subtract(Complex other) {
        double r = this.real - other.real;
        double i = this.imag - other.imag;
        return new Complex(r, i);
    }

    void print() {
        System.out.println(real + " + " + imag + "i");
    }

    public static void main(String[] args) {
        Complex c1 = new Complex(2, 3);
        Complex c2 = new Complex(5, 6);

        Complex sum = c1.add(c2);
        Complex diff = c1.subtract(c2);

        System.out.print("c1 = ");
        c1.print();

        System.out.print("c2 = ");
        c2.print();

        System.out.print("sum = ");
        sum.print();

        System.out.print("diff = ");
        diff.print();
    }
}


     





