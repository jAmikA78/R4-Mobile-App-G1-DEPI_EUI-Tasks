

import java.util.ArrayList;
import java.util.Scanner;

public class A3 {
    public static void main(String[] args) {
        System.out.print("Enter the IP Address: ");
        Scanner inp = new  Scanner(System.in);
        String Ip = inp.next();
        ArrayList<Integer> ip = new ArrayList<>();
        for  (int i = 0; i <= 3; i++) {
            ip.add(Integer.parseInt(Ip.split("\\.")[i]));
            System.out.println(ip.get(i));
        }

        for (int i=0; i<ip.size();i++) {
            if (ip.get(i) < 0 || ip.get(i) > 255) {
                System.out.println("This IP address is InValid: "+Ip);
                System.exit(0);
            }
        }
        System.out.println("This IP address is Valid: "+Ip);
    }
}
