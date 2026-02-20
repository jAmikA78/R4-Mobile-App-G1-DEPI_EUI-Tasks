import kotlin.random.Random

fun main(){
    val randomNum = Array(100) {
        Random.nextInt(1, 101)
    }
    for(num in randomNum){
        if (num <= 10){
            println(num)
        }
    }
}