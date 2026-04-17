abstract class Shape {

    private var dim: Double = 0.0

    fun setDim(d: Double) {
        dim = d
    }

    fun getDim(): Double {
        return dim
    }

    protected fun getDimension(): Double {
        return dim
    }

    abstract fun calcArea(): Double
}

class Circle() : Shape() {

    constructor(r: Double) : this() {
        setDim(r)
    }

    override fun calcArea(): Double {
        val r = getDimension()
        return Math.PI * r * r
    }
}

class Triangle() : Shape() {

    private var height: Double = 0.0

    constructor(b: Double, h: Double) : this() {
        setDim(b)
        height = h
    }

    fun setHeight(h: Double) {
        height = h
    }

    fun getHeight(): Double {
        return height
    }

    override fun calcArea(): Double {
        return 0.5 * getDimension() * height
    }
}

class Rectangle() : Shape() {

    private var height: Double = 0.0

    constructor(w: Double, h: Double) : this() {
        setDim(w)
        height = h
    }

    fun setHeight(h: Double) {
        height = h
    }

    fun getHeight(): Double {
        return height
    }

    override fun calcArea(): Double {
        return getDimension() * height
    }
}

class Picture {

    fun sumAreas(s1: Shape, s2: Shape, s3: Shape): Double {
        return s1.calcArea() + s2.calcArea() + s3.calcArea()
    }
}


fun main() {

    val c = Circle(5.0)
    val t = Triangle(4.0, 6.0)
    val r = Rectangle(3.0, 7.0)

    val picture = Picture()
    val totalArea = picture.sumAreas(c, t, r)

    println("Total Area = $totalArea")
}
