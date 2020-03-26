package com.example.kotlinclass

class Program2{
    fun addTwoNumbers(a: Int, b: Int, action: (Int, Int) -> Unit) {
        println("*********** addTwoNumbers with Lambda *************")
//        val sum = action(a, b)
//        println("Sum: $sum")
        action(a, b)
    }

}
fun main() {
    val program = Program2()
    var result: Int = 0
//  We can modify the outside value of result inside the
//    Lambda, and that is the "closure"
    println("R1: $result")
    val myLamda: (Int, Int) -> Unit = {x, y -> result = x + y}
//    program.addTwoNumbers(2, 7) {x, y -> result = x + y}
    program.addTwoNumbers(2, 7, myLamda)
    println("R2: $result")
}