package com.example.kotlinclass



fun pTest3() {
    println("*********** pTest 3 *************")
    println(duplicateNonZero(listOf(3, 0, 5)))
    println(duplicateNonZeroV2(listOf(3, 0, 5)))
}
fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0) return listOf()
        listOf(it, it)
    }
}

fun duplicateNonZeroV2(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0) return@flatMap listOf<Int>()
        listOf(it, it)
    }
}

fun pTest2() {
    println("*********** pTest 2 *************")
//    val f1: () -> Int? = null
    val f2: () -> Int? = { null }
    val f3: (() -> Int)? = null
//    val f4: (() -> Int)? = { null }
}
fun pTest1() {
    println("*********** pTest 1 *************")
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val isEven = { i: Int -> i % 2 == 0 }
    println(isEven)
}

fun main() {
    pTest1()
    pTest2()
    pTest3()
}