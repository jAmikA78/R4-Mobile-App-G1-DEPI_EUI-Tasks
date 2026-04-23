public class Main {
    public static void main(String[] args) {

        Child c = new Child();
        c.num1 = 5;
        c.num2 = 10;
        c.num3 = 15;

        System.out.println(c.sum());
    }
}

class Parent {
    int num1;
    int num2;

    int sum() {
        return num1 + num2;
    }
}

class Child extends Parent {
    int num3;

    int sum() {
        return num1 + num2 + num3;
    }
}