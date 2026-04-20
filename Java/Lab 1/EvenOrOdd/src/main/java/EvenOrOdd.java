import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("================ Even Or Odd ================");
        System.out.println("Enter a Number");
        System.out.print(">> ");
        int num = scanner.nextInt();
        if(num % 2 == 0)
            System.out.println("Even");
        else
            System.out.println("Odd");

    }
}
