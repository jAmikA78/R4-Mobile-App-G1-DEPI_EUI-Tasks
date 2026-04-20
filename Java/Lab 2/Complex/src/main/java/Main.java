public class Main {
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(2, 5);
        ComplexNumber c2 = new ComplexNumber(3, 10);

        System.out.print("c1: ");c1.print();
        System.out.print("c2: ");c2.print();

        System.out.print("addition: ");ComplexNumber.add(c1,c2).print();
        System.out.print("Subtraction: ");ComplexNumber.subtract(c2,c1).print();



    }

}
