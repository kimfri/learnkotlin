package com.example.kotlinclass

class Program {
//    High Level fun -> takes an Lambda as input
//    1) The same in action: (Int)->Unit
    fun addTwoNumbers(a: Int, b: Int, action: (Int) -> Unit) {
        println("*********** addTwoNumbers with Lambda *************")
        val sum = a + b
        action(sum)
    }

    fun addTwoNumbers(a: Int, b: Int, action: MyInterface) {
        println("*********** addTwoNumbers with Interface *************")
        val sum = a + b
        action.execute(sum)
    }

    fun addTwoNumbers(a: Int, b: Int) {
        println("*********** addTwoNumbers *************")
        val sum = a + b
        println(sum)
    }
}

class Printer {
    fun printTypeOne(x: Int, y: Int, action: (Int, Int)->Int) {
        val answer = action(x, y)
        println("Answer: $answer")
    }
}

interface MyInterface { fun execute(sum: Int) }

fun main() {
    val program = Program()
    program.addTwoNumbers(2, 7)
    program.addTwoNumbers(2, 7, object: MyInterface {
        override fun execute(sum: Int) {
            println(sum)
        }
    })
    program.addTwoNumbers(1, 2, object: MyInterface {
        override fun execute(sum: Int) {
            println("This is samesame but different: $sum")
        }

    })
//    val test: String = "Hello"
//  val myLamda: (type of sum) -> typeOfReturnValue
//   1) (Int)->Unit
    val myLambda: (Int) -> Unit = { sum -> println(sum)}
    program.addTwoNumbers(2, 7, myLambda)
    program.addTwoNumbers(2, 7, { sum -> println(sum)}) //Less readable

    val lambdaSum: (Int, Int)->Int = {x, y -> x + y}
    val lambdaSub: (Int, Int)->Int = {x, y -> x - y}
    Printer().printTypeOne(3, 9, lambdaSum)
    Printer().printTypeOne(3, 9, lambdaSub)
    Printer().printTypeOne(3, 9, {x, y -> x - y})
    Printer().printTypeOne(3, 9) {x, y -> x - y}
}