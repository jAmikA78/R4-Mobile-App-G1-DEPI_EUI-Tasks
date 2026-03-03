enum class Building {
  VILLA,
  APARTMENT
}

class Person(val name: String) {
  var address: Address? = null

  class Address(val street: String, val city: String, val building: Building) {
    override fun toString(): String = "$street, $city, $building"
  }

  fun setAddress(street: String, city: String, building: Building) {
    address = Address(street, city, building)
  }
}

fun main() {
  val person = Person("Ahmed Ibrahim")
  person.setAddress("3 Said Amer St", "MetNama", Building.APARTMENT)
  println("Person: ${person.name}, Address: ${person.address}")
}
