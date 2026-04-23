public class mainComplex {
  public static void main(String[] args) {
    Complex c1 = new Complex(3, 2);
    Complex c2 = new Complex(1.5, 4.5);
    c1.add(c2);
    c1.printComplex();
    c1.sub(c2);
    c1.sub(c2);
    c1.printComplex();
  }
}
