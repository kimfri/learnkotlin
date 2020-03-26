package com.example.kotlinclass

open class Parent
class Child : Parent()

fun Parent.foo() = "parent"
fun Child.foo() = "child"

fun main() {
    val parent : Parent = Child()
    println("--> ${parent.foo()}")
}