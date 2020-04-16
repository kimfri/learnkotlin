package com.kimfri.globofly.differenttests

fun main() {
//    greet()
//    cesar1()
    cesar2()
}

fun cesar2() {
    println(
        listOf(
            166, 226, 44, 200, 234, 214, 208,
            204, 62, 142, 200, 258, 214, 204, 64
        )
            .asSequence()
            .map { it / 2 }
            .map { it + 1 }
            .filter { it in 32..114 }
            .map { it.toChar() }
            .joinToString(separator = "")
    )

}

fun cesar1() {
    listOf(
        83, 113, 22, 100, 117, 107, 104,
        102, 31, 71, 100, 129, 107, 102, 32
    )
        .map { it + 1 }
        .filter { it in 32..114 }
        .onEach { print(it.toChar()) }
}


//84 114 101 118 108 105 103 32 72 101 108 103 33

fun greet() {
    val msg = "Trevlig Helg!".toByteArray()
    msg.forEach {
        val value: Int = it.toInt()
        print(" $value")
    }
}
