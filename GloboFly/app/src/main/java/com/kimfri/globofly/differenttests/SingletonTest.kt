package com.kimfri.globofly.differenttests

data class Book(val name: String)

object BookShelf {
    val books = arrayListOf<Book>()
    fun showBooks() {
        books.forEach {
            println(it.toString())
        }
    }

    fun sellAllBooks() {
        books.clear()
    }
}

fun main() {
    BookShelf.books.add(Book("apa"))
    BookShelf.books.add(Book("bepa"))
    BookShelf.books.add(Book("cepa"))

    BookShelf.showBooks()
    BookShelf.sellAllBooks()
    BookShelf.books.add(Book("epa"))
    BookShelf.showBooks()
}