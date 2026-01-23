public class assi1 {

    public static void main(String[] args) {
    System.out.println("Hello java ");
    
    int x= 10;
    if (x%2==0){
        System.out.println("Even number");
    }
    else{
        System.out.println("Odd number");

    }

    String ip ="163.121.12.30";
    String [] parts= ip.split("\\.");
        for(String part : parts){
            System.out.println(part);
            
        }
    }
}
