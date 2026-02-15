

import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        System.out.print("Enter the Number: ");
        Scanner inp = new  Scanner(System.in);
        int a = inp.nextInt();
        if (a%2 == 0){
            System.out.println("The Number is Even");
        }else{
            System.out.println("The Number is Odd");
        }
    }
}
