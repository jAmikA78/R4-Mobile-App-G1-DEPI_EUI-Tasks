fun displayMenu(){
    println("1. +")
    println("2. -")
    println("3. /")
    println("4. *")
    print(">> ")
}
fun main(){
    println("=================== Calc App ===================")
    while (true){
        println("1. Enter Numbers")
        println("2. Exit")
        print(">> ")
        var choice = readln().toInt()
        var num1 : Double = 0.0
        var num2 : Double = 0.0
        if(choice == 1){
            try {
                print("Enter 1st Number: ")
                num1 = readln().toDouble()
                print("Enter 2nd Number: ")
                num2  = readln().toDouble()
            }catch (e : NumberFormatException){
                println("Please Enter a Valid Number ${e.message} is not a Number")
                continue
            }
            displayMenu()
            choice = readln().toInt()
            when(choice){
                1 -> println("Result = ${num1 + num2}")
                2 -> println("Result = ${num1 - num2}")
                3 -> println("Result = ${num1 / num2}")
                4 -> println("Result = ${num1 * num2}")
                else -> println("Invalid Choice")

            }
        }
        else if(choice == 2)
            break
        else{
            println("Invalid choice")
        }


    }

}