package org.example



abstract class Shape {
    var dim: Double = 0.0

    fun setDim(d: Double) {
        dim = d
    }

    fun getDim(): Double {
        return dim
    }

    abstract fun calcArea(): Double
}



class Rectangle( var height: Double ) : Shape() {

    constructor(w: Double, h: Double) : this(h) {
        dim = w
    }

    fun setHeight(h: Double) {
        height = h
    }

    fun getHeight(): Double {
        return height
    }

    override fun calcArea(): Double {
        return dim * height
    }
}



class Circle() : Shape() {

    constructor(r: Double) : this() {
        dim = r
    }

    override fun calcArea(): Double {
        return 3.14* dim * dim
    }
}


class Triangle(var height: Double = 0.0) : Shape() {

    constructor(b: Double, h: Double) : this(h) {
        dim = b
    }

    fun setHeight(h: Double) {
        height = h
    }

    fun getHeight(): Double {
        return height
    }

    override fun calcArea(): Double {
        return 0.5 * dim * height
    }
}


class Picture {

    fun sumAreas(s1: Shape, s2: Shape, s3: Shape): Double {
        return s1.calcArea() + s2.calcArea() + s3.calcArea()
    }
}



fun main() {

    val r= Rectangle(12.0, 5.0)
    val c = Circle(5.0)
    val t = Triangle(5.0, 4.0)
    val p = Picture()
   println("The sum of Area is ${p.sumAreas(r,c,t)}")


}
