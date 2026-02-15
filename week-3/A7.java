

public class A7 {
    public static void main(String[] args){
        Csum sum=new Csum(22,55,7);
        System.out.println(sum.sum());
    }
}

class Psum{
    protected int num1,num2;

    public void set_num1(int n){
	if(n >=  0){
	  num1 = n;
        }
    }

    public void set_num2(int n){
	if(n >= 0){
	  num2 = n;
        }
    }

    public int get_num1(){
	return num1;
    }

    public int get_num2(){
	return num2;
    }

    public int sum(){
        return num1+num2;
    }
}

class Csum extends Psum{
    protected int num3;

    public Csum(int num1,int num2,int num3){
        set_num1(num1);
        set_num2(num2);
        this.num3=num3;
    }
    public int sum(){
        return num1+num2+num3;
    }
}
