import kotlin.math.pow
fun calculate(a:Int, b:Int, operation: (Int, Int) -> Double): Double {
    return operation(a, b)
}
fun main() {
    println("Addition: " + calculate(10, 5) { x, y -> (x+y).toDouble() })
    println("Subtraction: " + calculate(10, 5) { x, y -> (x-y).toDouble() })
    println("Multiplication: " + calculate(10, 5) { x, y -> (x*y).toDouble() })
    println("Division: " + calculate(10, 5) { x, y -> (x/y).toDouble() })
    println("Power: " + calculate(2, 3) { x, y -> x.toDouble().pow(y) })
}