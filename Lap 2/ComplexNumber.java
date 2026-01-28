class Complex {
    int real;
    int imaginary;

Complex(int real, int imaginary) {
    this.real = real;
    this.imaginary = imaginary;
}

Complex add(Complex c) {
    return new Complex(
        this.real + c.real,
        this.imaginary + c.imaginary
    );
}

Complex subtract(Complex c) {
    return new Complex(
        this.real - c.real,
        this.imaginary - c.imaginary
    );
}

void print() {
    System.out.println(real + " + " + imaginary + "i");
    }
}

public class ComplexNumber {
    public static void main(String[] args) {
        Complex c1 = new Complex(5, 6);
        Complex c2 = new Complex(2, 3);
        Complex sum = c1.add(c2);

        System.out.print("First Number: ");
        c1.print();

        System.out.print("Second Number: ");
        c2.print();

        System.out.print("Sum: ");
        sum.print();
    }
}
