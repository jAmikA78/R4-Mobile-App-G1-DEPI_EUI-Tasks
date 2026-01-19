

public class A7 {
    public static void main(String[] args){
        Csum sum=new Csum(22,55,7);
        System.out.println(sum.sum());
    }
}

class Psum{
    int num1,num2;

    public int sum(){
        return num1+num2;
    }
}

class Csum extends Psum{
    int num3;

    public Csum(int num1,int num2,int num3){
        this.num1=num1;
        this.num2=num2;
        this.num3=num3;
    }
    public int sum(){
        return num1+num2+num3;
    }
}