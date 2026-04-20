package com.mycompany.child;

 class Parent {
    int num1;
    int num2;

    Parent(int n1, int n2) {
        num1 = n1;
        num2 = n2;
    }

    int sum() {
        return num1 + num2;
    }
}

public class Child extends Parent {
    int num3;

    Child(int n1, int n2, int n3) {
        super(n1, n2);
        num3 = n3;
    }

    @Override
    int sum() {
        return num1 + num2 + num3;
        // أو: return super.sum() + num3;
    }

    public static void main(String[] args) {
        Parent p = new Parent(3, 4);
        System.out.println("Parent sum = " + p.sum());

        Child c = new Child(3, 4, 5);
        System.out.println("Child sum = " + c.sum());
    }
}
