package com.example.lamdas

fun List<Int>.allNonZero() =  all { it != 0}    //alla elementen matchar --> true
fun List<Int>.allNonZero1() =  none { it == 0 } // om INGET värde matchar --> true
fun List<Int>.allNonZero2() =  !any { it == 0 }  //om något värde matchar --> true

fun List<Int>.containsZero() =  any { it == 0 }
fun List<Int>.containsZero1() =  !all { it != 0 }
fun List<Int>.containsZero2() =  !none { it == 0 }

fun main(args: Array<String>) {
    val list1 = listOf(1, 2, 3)

    if (list1.allNonZero() != true) {println("Line 1 error")}
    if (list1.allNonZero1() != true) {println("Line 2 error")}
    if (list1.allNonZero2() != true) {println("Line 3 error")}

    if (list1.containsZero() != false) {println("Line 4 error")}
    if (list1.containsZero1() != false) {println("Line 5 error")}
    if (list1.containsZero2() != false) {println("Line 6 error")}

    val list2 = listOf(0, 1, 2)
    if (list2.allNonZero() != false) {println("Line 7 error")}
    if (list2.allNonZero1() != false) {println("Line 8 error")}
    if (list2.allNonZero2() != false) {println("Line 9 error")}

    if (list2.containsZero() != true) {println("Line 10 error")}
    if (list2.containsZero1() != true) {println("Line 11 error")}
    if (list2.containsZero2() != true) {println("Line 12 error")}
}
