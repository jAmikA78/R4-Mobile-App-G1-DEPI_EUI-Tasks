abstract class Shapes(){
    abstract fun area(): Double
}
class Circle(private val radius: Double): Shapes() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

class Rectangle(private val length: Double, private val width: Double): Shapes() {
    override fun area(): Double {
        return length * width
    }
}

class Triangle(private val length: Double, private val width: Double): Shapes() {
    override fun area(): Double {
        return .5*length * width
    }
}

class picture(private s1:Shapes,private s2:Shapes,private s3:Shapes){
    fun sumArea():Double{
        return s1.area()+s2.area()+s3.area()
    }
}

fun main(){
  val Circle=Circle(5)
  val Rectangle=Rectangle(4.0,6.0)
  val Triangle=Triangle(3.0,4.0)
  val picture=picture(Circle,Rectangle,Triangle)
  println("Sum of areas: ${picture.sumArea()}")
}