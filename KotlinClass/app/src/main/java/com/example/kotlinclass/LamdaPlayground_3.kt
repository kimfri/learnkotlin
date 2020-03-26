package com.example.kotlinclass

fun main() {
    val program = Program3()
//    program.reverseAndDisplay("hello", { s -> s.reversed() })
    program.reverseAndDisplay("hello") { it.reversed() }
    program.reverseAndDisplay("hello") { str -> str.reversed() }


//    val reverser: (String) -> String = { str -> str.reversed()}
//    program.reverseAndDisplay("hello", reverser)
}

class Program3 {
    fun reverseAndDisplay(str: String, myFunc: (String) -> String) {
        var result = myFunc(str)
        println(result)
    }
}