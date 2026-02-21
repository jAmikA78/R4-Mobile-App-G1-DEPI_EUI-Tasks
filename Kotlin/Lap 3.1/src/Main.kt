class Person(val name: String, val address: Address){
    class Address(val streetName: String, val city: String, val building: Building)
        enum class Building{
            VILLA,
            APARTMENT
        }
    }

fun main() {
    val address= Person.Address("Kornish st","Giza", Person.Building.APARTMENT)
    val person= Person("Abdulrahman",address)
    println("City: ${person.address.city}")
    println("Building: ${person.address.building}")
    println("Name: ${person.name}")
}