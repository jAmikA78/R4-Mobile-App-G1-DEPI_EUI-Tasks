package org.example//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    while (true) {


        println("Enter first number:")
        val num1 = readLine()?.toDouble()

        println("Enter second number:")
        val num2 = readLine()?.toDouble()

        if (num1 == null || num2 == null) {
            println("Invalid")

            continue
        }

        println("The sum is: ${num1 + num2}")
        println("The subtraction is: ${num1 - num2}")
        println("The multiplication is: ${num1 * num2}")
        println("The division is: ${num1 / num2}")
        break
    }


    }