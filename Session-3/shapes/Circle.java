public class Circle extends Shape {

  @Override
  public double area() {
    return Math.PI * getDim() * getDim();
  }
  
}
