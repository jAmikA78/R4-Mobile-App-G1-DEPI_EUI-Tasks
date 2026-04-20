import kotlin.math.pow

fun main(){
    while (true){
        println("====== Calculator App ======")
        print("Enter First Number : ")
        var num1  = readln().toDouble()
        print("Enter Second Number : ")
        var num2  = readln().toDouble()
        println("What operation do you want to perform ?")
        displayMenu()
        var choice = readln().toInt()
        when(choice){
            1 -> println("Result = ${calculate(num1,num2,::add)}")
            2 -> println("Result = ${calculate(num1,num2,::sub)}")
            3 -> println("Result = ${calculate(num1,num2,::mult)}")
            4 -> println("Result = ${calculate(num1,num2,::div)}")
            5 -> println("Result = ${calculate(num1,num2,::pow)}")
            6 -> break
            else -> println("Invalid Input")

        }


    }
}
fun displayMenu(){
    print("1. Add\n2. Subtraction\n3. Multiply\n4. Division\n5. Power(first^second)\n" +
            "6. Exit\n>> ")
}

inline fun calculate(num1: Double, num2: Double, operation: (Double, Double) -> Double) : Double {
    return operation(num1,num2)
}

fun add(num1: Double,num2: Double) =  num1 + num2
fun sub(num1: Double,num2: Double) =  num1 - num2
fun mult(num1: Double,num2: Double) =  num1 * num2
fun div(num1: Double,num2: Double) =  num1 / num2
fun pow(num1: Double,num2: Double) = num1.pow(num2)