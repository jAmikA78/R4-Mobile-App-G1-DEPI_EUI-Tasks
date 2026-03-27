package org.example

fun main() {
    println("Enter you name: ")
    val input = readLine()

    println("1) if condition check")
    println("2) Elvis operator check")
    val choice = readLine()

    val name : String? = when (choice) {
        "1" -> if (input.isNullOrBlank()) "Guest" else input
        "2" -> input ?: "Guest"
        else -> "Guest"
    }

    println("Hello $name!")
}