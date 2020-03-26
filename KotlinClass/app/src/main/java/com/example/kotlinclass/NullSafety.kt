package com.example.kotlinclass

/*
*  ?. Safe Call Operator
*  ?: Elvis Operator
*  !! Not-null Assertion
*  ?.let {..} Safe Call with let
* */
fun main() {
    val name: String? = null

    //1. Safe Call (?.)
    //Returns the lenght if 'name' is not null else retuns NUL
    //Use it if your don't mind getting NULL value
    println("The len of name is: ${name?.length}")


    //2. Safe call with let (?.let)
    //It executes the block ONLY IF name is NOT NULL
    name?.let {
        println("The len of name is: ${name.length}")
    }

    //3. Elvis-operator (?:)
    //When we have nullable reference 'name', we can say
    // "if name is not null", use it,
    // otherwise use some non-null value
//    val len = if (name != null)
//        name.length
//    else -1

    val len2 = name?.lastIndex ?: -1
    println("len2: $len2")

    //4. Non-null assertion operator (!!)
    //Use it when you are sure the value is NOT NULL
    //Throws NPI if the value is found to be null
    println("The len of name is: ${name!!.length}")
}

