public class ComplexNumber {
    private int real;
    private int imag;

    public ComplexNumber() {
    }

    public ComplexNumber(int real) {
        this.real = real;
    }

    public ComplexNumber(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    public static ComplexNumber add(ComplexNumber c1,ComplexNumber c2){

        return new ComplexNumber(c1.getReal() + c2.getReal(),c1.getImag() + c2.getImag());
    }
    public static ComplexNumber subtract(ComplexNumber c1,ComplexNumber c2){

        return new ComplexNumber(c1.getReal() - c2.getReal(),c1.getImag() - c2.getImag());
    }
    public void print(){
        System.out.println(real + (imag > 0 ? " + ":" ") + imag + "i");
    }

    public int getImag() {
        return imag;
    }

    public void setImag(int imag) {
        this.imag = imag;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }
}
