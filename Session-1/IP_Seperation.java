import java.util.Scanner;

public class IP_Seperation {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.err.println("Please enter ai IP address like : 192.168.1.1");
    String ipAddress = scanner.nextLine();
    String[] arr = ipAddress.split("\\.");
    if(arr.length != 4){
      System.out.println("Invalid IP Address");
      return;
    }
    for (String temp:arr){
      int cur = Integer.parseInt(temp);
      if(cur < 0 || cur > 255){
        System.out.println("Invalid IP Address");
        return;
      }
    }
    for (String temp : arr) {
      System.out.println(temp);
    }
  }
}
