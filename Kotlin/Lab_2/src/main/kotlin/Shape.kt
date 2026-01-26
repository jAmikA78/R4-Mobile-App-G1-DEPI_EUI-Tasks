abstract class Shape(var dim : Double) {

    abstract fun calcArea() : Double

}

class Rectangle(dim : Double,var height: Double) : Shape(dim){

    override fun calcArea(): Double {
        return dim * height
    }
}

class Triangle(dim : Double,var height: Double) : Shape(dim){

    override fun calcArea(): Double {
        return (0.5 * dim) * height
    }

}

class Circle(dim : Double) : Shape(dim){

    override fun calcArea(): Double {
        return 3.14 * (dim * dim)
    }

}

class Picture(){
    fun sumAreas(s1 : Shape,s2 : Shape, s3 : Shape) : Double{
        return s1.calcArea() + s2.calcArea() + s3.calcArea()
    }
}
fun main(){
    val picture = Picture()
    val rect = Rectangle(3.0,2.0) // 6
    val circle = Circle(4.0) //
    val triangle = Triangle(2.0,4.0) // 4

    println("Sum Areas = ${picture.sumAreas(rect,circle,triangle)}")


}