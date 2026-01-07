public class Main3 {
    public static void main(String[] args) {

        String IP = "163.121.12.30";
        String part = "";

        for (int i = 0; i < IP.length(); i++) {
            char p = IP.charAt(i);

            if (p == '.') {
                System.out.println(part);
                part = "";
            } 
            else {
                part += p;
            }
        }

        System.out.println(part);
    }
}