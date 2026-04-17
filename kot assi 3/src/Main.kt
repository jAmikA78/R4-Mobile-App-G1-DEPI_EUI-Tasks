
class Person(val name: String, val address: Address) {

    data class Address(
        val streetName: String,
        val city: String,
        val building: BuildingType
    )
}
enum class BuildingType {
    VILLA,
    APARTMENT
}
