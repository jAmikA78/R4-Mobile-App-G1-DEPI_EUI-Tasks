import kotlin.random.Random//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    //q1
    var name =readLine()

    if (name != null) {
            println("Hello $name")
    }
    else{
        name ="anon"
        println("Hello $name")

    }

    ///q2
    val numArray = IntArray(100)
    var i =0
    while(i < 100 ){
        numArray[i]=Random.nextInt(1, 101)
        if(numArray[i]<=10){
            println(numArray[i])
        }
        i++
    }


    //q3

    print("ent num1")
    val a1=readLine()?:"0"
    val a=a1.toDouble()

    print("ent op")
    val op=readLine()?:""

    print("ent num2")
    val b2=readLine()?:"0"
    val b=b2.toDouble()



    when(op){
        "+" ->print(a+b)
        "-" ->print(a-b)
        "*" ->print(b*a)
        "/" -> if (b != 0.0) print(a/b)

    }





}
