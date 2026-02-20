class Triangle(): Shape() {
    private var height: Double=0.0
   constructor(b: Double, h: Double): this(){
       setDim(b)
       height = h
   }
    fun getHeight(): Double{
        return height
    }
    fun setHeight(h: Double){
        height=h
    }

    override fun calcArea(): Double {
        return 0.5 * getDim() * height
    }
}