public class Main {
    public static void main(String[] args) {

        Complex co1 = new Complex();
        co1.setReal(5);
        co1.setImg(6);

        Complex co2 = new Complex();
        co2.setReal(2);
        co2.setImg(3);

        Complex sum = co1.add(co2);
        Complex sub = co1.subtract(co2);

        System.out.print("Add result: ");
        sum.print();

        System.out.print("Subtract result: ");
        sub.print();
    }
}

class Complex {

    private int real;
    private int img;

    public void setReal(int r) {
        real = r;
    }

    public void setImg(int i) {
        img = i;
    }

    public int getReal() {
        return real;
    }

    public int getImg() {
        return img;
    }

    Complex add(Complex c) {
        Complex result = new Complex();
        result.real = this.real + c.real;
        result.img  = this.img  + c.img;
        return result;
    }

    Complex subtract(Complex c) {
        Complex result = new Complex();
        result.real = this.real - c.real;
        result.img  = this.img  - c.img;
        return result;
    }

    void print() {
        System.out.println(real + " + " + img + "i");
    }
}