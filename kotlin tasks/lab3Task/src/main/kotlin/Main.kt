package org.example

fun main() {
    val address = Person.Address("Faisal st.", "Giza", Building.APARTMENT)
    val person = Person("Zeyad", address)

    person.printInfo()
}

enum class Building{
    VILLA,
    APARTMENT
}

class Person(val name: String, val address: Address){
    // we used a nested class not an inner class, because the class don't need access to the outer class
    //it is more memory-efficient (don't have reference to the outer class)
    class Address(val street: String, val city: String, val building: Building){
        fun printAddress(){
            println("Street: $street \nCity: $city \nBuilding: $building")
        }
    }
    fun printInfo(){
        println("Name: $name")
        address.printAddress()
    }
}