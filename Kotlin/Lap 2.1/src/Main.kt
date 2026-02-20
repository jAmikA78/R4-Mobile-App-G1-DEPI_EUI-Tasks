abstract class Shape(){
    private var dim: Double = 0.0

    constructor(dim: Double) : this(){
        this.dim=dim
    }
    fun getDim(): Double{
        return dim
    }
    fun setDim(d: Double){
        dim = d
    }
    abstract fun calcArea(): Double
}
fun main() {
    val rec = Rectangle(4.0,6.0)
    val cir = Circle(5.0)
    val tir = Triangle(3.0,8.0)

    val picture = Picture()
    val total = picture.sumAreas(rec,cir,tir)
    println("Total Area = $total")
}