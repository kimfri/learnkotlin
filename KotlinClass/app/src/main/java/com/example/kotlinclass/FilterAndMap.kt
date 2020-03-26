package com.example.kotlinclass

/*
* Filter -> Returns a list containing only matching
* elements from the given [predicate]
* (predicate returns true/false)
* */
/*
* Map a list from the result when appliing the given
* [transform]
* */

fun main() {
    val myNumbers = listOf(2, 3, 4, 6, 23, 90)
//    val mySmallNums = myNumbers.filter { v -> v < 10 }
    val mySmallNums = myNumbers.filter { it < 10}
    println(mySmallNums)

//    val mySquardNums = myNumbers.map {num -> num * num }
    val mySquardNums = myNumbers.map {it * it}
    println(mySquardNums)

    val mySmallSquares = myNumbers
        .filter { it < 10 }
        .map { it * it }
    println( "--> $mySmallSquares")

    val people= listOf<Person>(
        Person(45, "Kim"),
        Person(43, "Maria"),
        Person(15, "Wille"),
        Person(13, "Theo"))
    val names = people
        .filter { it.name.contains('K')}
        .map { it.name }

    println(names)
}

class Person(var age: Int, var name: String) {

}