
package eui;

import java.util.Scanner;

public class EUI {

    public static void main(String[] args) {
    Scanner S =new Scanner(System.in);
        System.out.println("Enter The IP Address : ");
        String inputUser=S.nextLine();
        String[] parts =inputUser.split("\\.");
       Boolean valid =true;
       
       for(int i=0;i<4;i++){
           if(parts.length!=4){
               System.out.println("The IP address is not valid");
               break;
           }
           if(!parts[i].matches("\\d+")){
               valid=false;
               break;
           }
           int num =Integer.parseInt(parts[i]);
           if(0<=num && num>=255){
               valid=true;
               break;
           }
       }
    if(valid){
        System.out.println("The ip address is valid");
        for(int n=0;n<4;n++){
            System.out.println(parts[n]);
        }
    }else{
        System.out.println("The ip address is not valid");
    }
}
}