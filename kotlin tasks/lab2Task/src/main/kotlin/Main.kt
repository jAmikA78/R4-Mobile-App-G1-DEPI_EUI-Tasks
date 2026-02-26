package org.example

fun main() {
    val rect : Rectangle = Rectangle()
    rect.dim = 3.0
    rect.height = 5.0

    val cir: Circle = Circle(3.0)

    val tri: Triangle = Triangle(4.0, 3.0)

    val pic: Picture = Picture()
    println("Circle Area: ${cir.calculateArea()}")
    println("Rectangle Area: ${rect.calculateArea()}")
    println("Triangle Area: ${tri.calculateArea()}")
    println("Summation of areas: ${pic.sumAreas(rect, tri, cir).toInt()}")
}

abstract class Shape(var dim : Double){
    constructor() : this(0.0)

    abstract fun calculateArea() : Double
}

class Rectangle(width : Double, var height : Double) : Shape(width){
    constructor() : this(0.0, 0.0)

    override fun calculateArea(): Double {
        return height*dim
    }
}

class Circle(radius : Double) : Shape(radius){
    constructor() : this(0.0)

    override fun calculateArea(): Double {
        return dim*dim*3.14
    }
}

class Triangle(base : Double,var height : Double) : Shape(base){
    constructor() : this(0.0, 0.0)

    override fun calculateArea(): Double {
        return height*dim*0.5
    }
}

class Picture{
    fun sumAreas(sh1 : Shape, sh2 : Shape, sh3 : Shape) : Double{
        return sh1.calculateArea() + sh2.calculateArea() + sh3.calculateArea()
    }
}