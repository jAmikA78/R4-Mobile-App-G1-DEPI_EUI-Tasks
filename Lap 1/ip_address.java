import java.util.Scanner;

public class ip_address {
    public static void main(String[] args){
        System.out.print("Enter The IP Address: ");
        Scanner sc = new Scanner(System.in);
        String ip=sc.nextLine();
        String num[] = ip.split("\\.");
        if(num.length != 4){
            System.out.println("Invalid IP Address");
        }
        else{
            for(int x=0; x<num.length; x++){
                System.out.println(num[x]);
            }
        }
    }
}
