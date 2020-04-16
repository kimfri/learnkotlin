package com.kimfri.globofly.differenttests

import androidx.core.text.isDigitsOnly
import com.google.gson.Gson
import com.google.gson.GsonBuilder

fun main() {
    simpleGsonJsonTest()
    prettyJsonTest()
    prettyJsonTest2()
    toStringTest()
    equalsTest()
    copyTest()
    scanner()

}

fun scanner() {
    println("Enter your name: ")
    var line: String? = null
    while(line == null) {
        line = getUserInput()
    }
    println("User input: $line")
    val age = getAge()
}

fun getAge(): Int {
    val age: String = "22"

    println("is digits: ${age.isOnlyDigits()}")
    return 0
}

fun String.isOnlyDigits(): Boolean {
    this.toCharArray()
        .filter {
            it.isLetter()
        }.first {
            return false
        }
    return true
}

fun getAge2(): Int {
    var line: String? = null
    var age = -1
    print("Enter your age: ")
    while(line == null && age < 0) {
        line = getUserInput()
        line?.let {
            if (it.isDigitsOnly()) {
                age = it.toInt()
            }
        }
        print("Now, enter your proper age: ")
    }
    return age
}

fun getUserInput() = readLine()

fun copyTest() {
    val user1= User("Kim", "Fritzon-Ölander")
    val user2 = user1.copy(age = 46)
    println(user1.toString())
    println(user2.toString())
}

fun equalsTest() {
    val user1= User("Kim", "Fritzon-Ölander")
    val user2 = User("Kim", "Fritzon-Ölander")
    println("Equals? ${user1 == user2}")
}

fun toStringTest() {
    println(User("Kim", "Fritzon-Ölander").toString())
}

fun prettyJsonTest2() {
    val users = listOf<User>(
        User("Kim", "Fritzon-Ölander"),
        User("Maria", "Fritzon-Ölander")
    )
    GsonBuilder()
        .setPrettyPrinting()
        .create()?.let {
            println("${it.toJson(users)}")
        }


}

fun prettyJsonTest() {
    val user1 = User("Kim", "Fritzon-Ölander")
    val gson = GsonBuilder().setPrettyPrinting().create()
    gson?.let {
        println("${it.toJson(user1)}")
    }
}

fun simpleGsonJsonTest() {
    val user1 = User("Kim", "Fritzon-Ölander")
    val gsonData = Gson().toJson(user1)
    println("-> $gsonData")
}

data class User(val firstName: String, val lastName: String, val age: Int? = null)