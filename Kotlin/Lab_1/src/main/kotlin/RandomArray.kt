import kotlin.random.Random

fun main(){
    val array = IntArray(100)
    for(index in array.indices){
        array[index] = (1..100).random()
    }
    for(number in array){
        if(number <= 10)
            println(number)
    }
}