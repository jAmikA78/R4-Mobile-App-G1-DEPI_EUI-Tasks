import java.util.Random

fun main () {
  val array=Array(100){
    Random().nextInt(0,100)
  }
  for (i in array){
    if (i<=10)
    println(i)
  }

}