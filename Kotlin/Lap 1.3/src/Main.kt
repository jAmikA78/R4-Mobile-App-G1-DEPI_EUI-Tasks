fun main() {
    print("Enter First Number: ")
    val num1 = readln().toDouble()
    print("Enter Second Number: ")
    val num2 = readln().toDouble()

    print("Enter Operation + - * / : ")
    val op = readln()

    val result = when (op){
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> {
            if(num2 != 0.0) num1 / num2 else{
                println("Error")
                return
            }
        }
    else -> {
        println("Invalid")
        return
        }
    }
    print("Result = $result")
}