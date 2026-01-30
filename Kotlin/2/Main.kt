package org.example

fun main(){
    print("Please enter your name: ")
    val name:String?=readLine()
    if(!name.isNullOrBlank()){

        println("welcome to $name")

    }else{

        println("No Text Entered")
    }




}