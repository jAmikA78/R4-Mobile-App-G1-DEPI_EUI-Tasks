fun main() {
    val name = readln()

    val greetingMessage =
        if (name.isEmpty()) "Hello guest"
        else "Hello $name"

    println(greetingMessage)
}
