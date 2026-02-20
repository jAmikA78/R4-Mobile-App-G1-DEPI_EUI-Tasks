class Rectangle() : Shape() {
    private var height: Double = 0.0

    constructor(w: Double, h: Double) : this() {
        setDim(w)
        height = h
    }
    fun getHeight(): Double {
        return height
    }
    fun setHeight(h: Double) {
        height = h
    }
    override fun calcArea(): Double {
        return getDim() * height
    }

}
