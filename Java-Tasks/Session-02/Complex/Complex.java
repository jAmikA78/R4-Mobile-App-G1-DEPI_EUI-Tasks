public class Complex {
  private double real;
  private double imag;

  public Complex(double real, double imag) {
    this.real = real;
    this.imag = imag;
  }

  public void setReal(double real) {
    this.real = real;
  }

  public double getReal() {
    return real;
  }

  public void setImag(double imag) {
    this.imag = imag;
  }

  public double getImag() {
    return imag;
  }

  public void add(Complex temp) {
    this.real += temp.real;
    this.imag += temp.imag;
  }
  

  public void sub(Complex temp) {
    this.real -= temp.real;
    this.imag -= temp.imag;
  }

  public void printComplex() {
    if (imag > 0)
      System.out.println("Complex Number: " + real + " + " + imag + "i");
    else if (imag < 0)
    System.out.println("Complex Number: " + real + " - " + (-imag) + "i");
  else
    System.out.println("Complex Number: " + real);
    
  }


}
