public abstract class Shape {

  private double dim;

  public void setDim(double dim) {
    this.dim = dim;
  }

  public double getDim() {
    return dim;
  }

  public abstract double area();
  
}
