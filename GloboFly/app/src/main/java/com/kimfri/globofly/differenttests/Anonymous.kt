package com.kimfri.globofly.differenttests

interface Human {
    fun talk()
}


fun main() {

    val person = (object : Human {
        override fun talk() {
            println("Inside talk....")
        }
    })
    person.talk()

}