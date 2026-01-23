package project;
 
class Parent {
    protected int num1;
    protected int num2;

    public Parent(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int sum() {
        return num1 + num2;
    }
}

class Child extends Parent {
    private int num3;

    public Child(int num1, int num2, int num3) {
        super(num1, num2);
        this.num3 = num3;
    }

    @Override
    public int sum() {
        return num1 + num2 + num3;
    }
}


public class New_2 {
    
    public static void main(String[]args){
    
        
        Parent p = new Parent(5, 10);
        System.out.println("Parent Sum = " + p.sum());

        Child c = new Child(5, 10, 15);
        System.out.println("Child Sum = " + c.sum());
         
}
    
    
}
