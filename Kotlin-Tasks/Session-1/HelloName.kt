fun main() {
  val name = readLine()

  if (name.isNullOrBlank()) {
    println("Hello, guest!")
  } else {
    println("Hello, $name!")
  }
}