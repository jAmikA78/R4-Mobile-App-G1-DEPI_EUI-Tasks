class Circle() : Shape() {
    constructor(r: Double) : this() {
        setDim(r)
    }

    override fun calcArea(): Double {
        return Math.PI * getDim() * getDim()
    }
}
