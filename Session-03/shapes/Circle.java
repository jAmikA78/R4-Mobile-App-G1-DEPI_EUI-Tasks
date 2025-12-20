public class Circle extends Shape {

  @Override
  public double area() {
    double radius = getDim();
    return Math.PI * radius * radius;
  }
  
}
