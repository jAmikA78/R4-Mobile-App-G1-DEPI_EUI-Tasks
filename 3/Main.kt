package org.example

import kotlin.random.Random

fun main() {

val numbers=Array(100){Random.nextInt(1,100)}
    val num:Int=0
    for(num in numbers){
        if(num<=10){
            println(num)
        }

    }


}