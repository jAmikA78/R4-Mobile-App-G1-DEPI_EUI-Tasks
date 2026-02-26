package org.example

import java.lang.Math.pow
fun power(a: Int, b: Int): Int = pow(a.toDouble(), b.toDouble()).toInt()

fun calculator(x:Int, y:Int, operation:(Int, Int)->Int) : Int {
    return operation.invoke(x,y)
}

val sum = {a:Int , b:Int -> a + b }
val sub = {a:Int , b:Int -> a - b }
val mul = {a:Int , b:Int -> a * b }
val div: (Int, Int) -> Int = { a:Int, b:Int -> if (b != 0) a/b else println("Invalid: can't divide by zero"); 0 }
val pow = {a:Int , b:Int -> power(a, b) }

fun main() {
    println("Sum of 2, 2 = ${calculator(2, 2, sum)}")
    println("Subtraction of 1, 2 = ${calculator(1 , 2 , sub)}")
    println("Multiplication of 1, 2 = ${calculator(1 , 2 , mul)}")
    println("Division of 16, 4 = ${calculator(16, 4 , div)}")
    println("Power of 3 , 2 = ${calculator(3, 2 ,pow)}")
}