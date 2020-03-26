package com.example.kotlinclass

//val pi: Float = 3.14f //waste of memory if we don't use it
val pi: Float by lazy { 3.14f }
fun main() {
    println("Some initial code")

    val area1 = pi * 4 * 4 //loaded into memory

    val area2 = pi *9 *9 //loaded from the cach

    println("some more code")
}