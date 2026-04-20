public class Main {
    public static void main(String[] args){
        Shape s1 = new Rectangle(2,5); // 10
        Shape s2 = new Triangle(5,10); // 25
        Shape s3 = new Circle(5); // 78.5

        System.out.println(AreaCalc.sumAreas(s1,s2,s3));
    }
}
