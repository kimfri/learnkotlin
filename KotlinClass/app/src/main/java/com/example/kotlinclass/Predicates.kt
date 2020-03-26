package com.example.kotlinclass

fun main() {
    val myNumbers = listOf(2, 3, 4, 6, 23, 90)

    val myPredicate= {num: Int -> num > 10}

//    myNumbers.all { num -> num > 10 }
    val check = myNumbers.all { it > 10 }
    println("check: $check")

    val bigNums = myNumbers.any(myPredicate)
    println("bigNums: $bigNums")

    val totalCount = myNumbers.count(myPredicate)
    println("totalCount: $totalCount")

    // returns the FIRST number that satisfies the lambda
    val firstValGtTen = myNumbers.find(myPredicate)
    println("first: $firstValGtTen")
}