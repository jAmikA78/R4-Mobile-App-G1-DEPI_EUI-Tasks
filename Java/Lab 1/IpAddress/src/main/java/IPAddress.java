import java.util.Scanner;

public class IPAddress {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("===================== IP Address Checker =====================");
        System.out.println("Enter your IP");
        System.out.print(">> ");
        String ip = scanner.nextLine();
        String[] ipChunks = ip.split("\\.");
        // if user entered invalid ip
        if(ipChunks.length < 4){
            System.out.println("Invalid IP Address");
            return;
        }
        for(String str : ipChunks){
            if ( str.isEmpty()|| Integer.parseInt(str) > 255){
                System.out.println("Invalid IP Address");
                return;
            }
        }
        // well-formatted ip print it
        for (String str : ipChunks)
            System.out.println(str);

    }
}
