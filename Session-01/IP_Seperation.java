public class IP_Seperation {
  public static void main(String[] args) {
    String ipAddress = "192.168.1.1";
    String[] arr = ipAddress.split("\\.");
    for (String temp : arr) {
      System.out.println(temp);
    }
  }
}
