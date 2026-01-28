class Parent {
    int num1;
    int num2;

    Parent(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    int sum() {
        return num1 + num2;
    }
}

class Child extends Parent {
    int num3;

    Child(int num1, int num2, int num3) {
        super(num1, num2);
        this.num3 = num3;
    }

    @Override
    int sum() {
        return num1 + num2 + num3;
    }
}

public class parent_main {
    public static void main(String[] args) {

        Parent p = new Parent(5, 10);
        System.out.println("Parent Sum = " + p.sum());

        Child c = new Child(5, 10, 15);
        System.out.println("Child Sum = " + c.sum());
    }
}
