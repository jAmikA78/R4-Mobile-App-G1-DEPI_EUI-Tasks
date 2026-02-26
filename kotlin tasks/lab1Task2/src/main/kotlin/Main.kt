package org.example

import kotlin.random.Random

fun main() {
    val array = arrayOfNulls<Int>(100)
    for (i in array.indices) {
        array[i] = Random.nextInt(1,101)
    }
    for (n in array) {
        n?.let { if (it <= 10) println(n) }
    }
}