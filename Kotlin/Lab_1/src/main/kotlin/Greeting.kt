fun main(){
    val name : String = readln()

    val greetingMessage : String = if(name.isEmpty()){
        "Hello guest"
    }else{
        "Hello $name"
    }
    println(greetingMessage)

}