package org.example

fun main() {

    val p1= Person("Ehab","Faisl")
    val (name,address) = p1
    println("name is $name ")
    println("address is $address")
    val add =Address("faisl street","Giza", buildin = Building.VILA)
    val(streetname,city,buldin)=add
    println("street is $streetname")
    println("city is $city")
    println ("buldin is $buldin")
}

data class Person(val name: String, val address: String)

data class Address(val streetName: String, val city: String, val buildin: Building)

enum class Building{
    VILA,
    APARTMENT;
}