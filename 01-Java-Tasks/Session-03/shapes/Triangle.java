public class Triangle extends Shape {

  private double height;

  public void setHeight(double height) {
    this.height = height;
  }

  public double getHeight() {
    return height;
  }

  @Override
  public double area() {
    double base = getDim();
    return 0.5 * base * height;
  }
}
