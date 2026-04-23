public class mainShape {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setDim(5);

        Rectangle rectangle = new Rectangle();
        rectangle.setDim(4);
        rectangle.setWidth(6);

        Triangle triangle = new Triangle();
        triangle.setDim(3);
        triangle.setHeight(7);

        Picture picture1 = new Picture();
        System.out.println("Total Area: " + picture1.calaAreas(circle, rectangle, triangle));
    }
}