fun main(){
  println("Enter 1st number:")
  val num1= readLine()!!.toDouble()
  println("Enter operation +, -, *, /")
  val operation= readLine()
  println("Enter 2nd number:")
  val num2= readLine()!!.toDouble()

  when(operation){
    "+"-> println("Result: ${num1+num2}")
    "-"-> println("Result: ${num1-num2}")
    "*"-> println("Result: ${num1*num2}")
    "/"-> {
      if (num2==0.0){
        println("Error: \"Division by zero\"")
      } else{
        println("Result: ${num1/num2}")
      }
    }
    else-> println("Error: \"Unknown operation\"")
  }

}