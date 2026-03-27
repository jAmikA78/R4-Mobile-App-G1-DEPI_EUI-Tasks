package org.example

import kotlin.math.abs

fun main() {
    println("Enter the first number: ")
    val num1 = readLine()?.toInt() ?: 0

    println("Enter the second number: ")
    val num2 = readLine()?.toInt() ?: 0

    println("Enter the operator (+, - , * , /) : ")
    val operator = readLine()

    val result = when (operator) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> if(num2 != 0) num1 / num2 else println("Can't divide by zero")
        else -> println("Invalid operator")
    }

    println("Result: $result")
}