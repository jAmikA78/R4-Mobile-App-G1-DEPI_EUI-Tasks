

public class A5 {
    public static void main(String[] args) {
        Complex c1 = new Complex(5,9);
        Complex c2 = new Complex(-4,1);
        Complex c3 = new Complex();

        Complex re1 = Complex.add(c1,c2);
        Complex re2 = Complex.sub(c2,c1);

        re1.print();
        re2.print();
        c3.print();
    }
}

class Complex{
    private int real,img;

    public static Complex add(Complex num1, Complex num2){
        int rsum = num1.real + num2.real;
        int isum = num1.img + num2.img;
        return new Complex(rsum, isum);
    }
    public static Complex sub(Complex num1, Complex num2){
        int rsum = num1.real - num2.real;
        int isum = num1.img - num2.img;
        return new Complex(rsum, isum);
    }

    public Complex(){
        this.real = 0;
        this.img = 0;
    }

    public Complex(int real, int img){
        this.real = real;
        this.img = img;
    }

    public void print(){
        if (img >= 0){
            System.out.println("Complex Number: "+real+"+"+img+"i");
        }
        else {
            System.out.println("Complex Number: "+real+img+"i");
        }

    }
}