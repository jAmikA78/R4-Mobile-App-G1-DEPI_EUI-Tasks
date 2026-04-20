public class Parent {
    protected int num1;
    protected int num2;

    public Parent() {
    }

    public Parent(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int sum(){
        return num1 + num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}

class Child extends Parent{
    private int num3;

    public Child() {
    }

    public Child(int num1, int num2, int num3) {
        super(num1, num2);
        this.num3 = num3;
    }

    @Override
    public int sum(){
        return num1 + num2 + num3;
    }
}
