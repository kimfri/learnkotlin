package com.example.kotlinclass

fun main() {
    val s: String? = null

    val length: Int? = s?.length
    println("Length: $length")

//    test1()
//    test2()
//    test3()
//    test4()
    test5()
}

fun test5() {
    println("********* Start test 5 **********")
//    val s = TODO()
//    val s: String? = "5"
//    println(s as? Int)    // null
//    println(s as Int?)    // exception
    println("********* End test 5 **********")
}

fun test3() {

}

fun foo(list1: List<Int?>, list2: List<Int>?) {
    list1.size
    list2?.size

    val i: Int? =
        list1.get(0)
    val j: Int? =
        list2?.get(0)
}

fun test4() {
    val s1: String? = null
    val s2: String? = ""
    s1?.isEmptyOrNull() == true
    s2?.isEmptyOrNull() == true

    val s3 = "   "
    s3.isEmptyOrNull() == false
}

fun String?.isEmptyOrNull() = (this == null || this.isEmpty())


fun test2() {
    val x: Int? = 1
    val y: Int = 2
    val sum = x ?: 0 + y
    println(sum)
}

fun test1() {
    val a: Int? = null
    val b: Int? = 1
    val c: Int = 2

    val s1 = (a ?: 0) + c
    val s2 = (b ?: 0) + c
    println("$s1$s2")
}



