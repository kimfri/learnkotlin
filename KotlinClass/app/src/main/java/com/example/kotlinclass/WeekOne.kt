package com.example.kotlinclass

import java.util.*

fun foo(): String {
    println("Calculating foo..")
    return "foo"
}

fun displaySeparator(character: Char = '*', size: Int = 10) {
    repeat(size) {
        print(character)
    }
}

fun forLoopTest() {
    val list = listOf("a", "b", "c")
    for (s: String in list) {
        print(s)
    }
    println("")
    for (i in 9 downTo 1 step 2) {
        println(i)
    }
    for (ch in "abc") {
        print(ch + 1)
    }
    println()
    for (c in '0' until '9') {
        print(c)
    }
}

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter"
    else -> "I don't know"
}


fun main() {
    println("First ${foo()}, Second: ${foo()}")

    println(
        listOf('a', 'b', 'c').joinToString(
            separator = "-", prefix = "(", postfix = ")"
        )
    )

    displaySeparator(character = '5', size = 3)
    forLoopTest(); println()
    println(recognize('1'))

    //K is between J and S --> true
    println("Kotlin" in "Java".."Scala")
    //Kotlin is not present in the set --> false
    println("Kotlin" in setOf("Java","Scala"))

    val s1 = "Kalle"
    val s2 = "Kula"
    val s12 = s1 to s2
    println("first: ${s12.first}, second: ${s12.second}")

}