public class Rectangle extends Shape {

  private double width;

  public void setWidth(double width) {
    this.width = width;
  }

  public double getWidth() {
    return width;
  }

  @Override
  public double area() {
    double length = getDim();
    return length * width;
  }

}
