package com.example.kotlinclass

fun isValidIdentifier(s: String): Boolean {
    if (s.isEmpty()) return false
    val list = s.toList()

    for((index, element) in list.withIndex()) {
        if (index == 0) {
            if(!element.isValidStart()) return false
        } else {
            if(!(element.isLetterOrDigit())) return false
        }
    }
    return true
}

fun Char.isValidStart() = isLetter() || this == '_'

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}