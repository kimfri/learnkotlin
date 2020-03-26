package com.example.lamdas

val heroes = listOf(
    Hero("The Captian", 60, Gender.MALE),
    Hero("Frenchy", 42, Gender.MALE),
    Hero("The kid", 9, null),
    Hero("Lady Lauren", 29, Gender.FEMALE),
    Hero("First Mate", 29, Gender.MALE),
    Hero("Sir Stephen", 37, Gender.MALE)
)
fun test12Better() {
    println("*********** Test 12_better *************")
    println("*********** Better code *************")
    val allPossiblePairs = heroes.
        flatMap { first ->
                    heroes.map {second ->
                        first to second
                    }
        }
    val (oldest, youngest) = allPossiblePairs
        .maxBy { it.first.age - it.second.age }!!
    println(oldest.name)
    println("*********** Even better *************")
    val maxAgeHero = heroes.maxBy { hero -> hero.age }!!
    println(maxAgeHero.name)
}
fun test12() {
    println("*********** Test 12 *************")
    println("*********** Bad code *************")
    val (first, second) = heroes
        .flatMap { heroes.map { hero -> it to hero } }
        .maxBy { it.first.age - it.second.age }!!
    val name = first.name
    println(name)
}
fun test11() {
    println("*********** Test 11 *************")
    val mapByName = heroes.associateBy { it.name }
    val unknownHero = Hero("Unknown", 0, null)
    val age = mapByName.getOrElse("unknown") { unknownHero }.age
    println(age)
}
fun test10() {
    println("*********** Test 10 *************")
    val mapByName: Map<String, Hero> =
        heroes.associateBy { it.name }
    val age = mapByName["Frenchy"]?.age
    println(age)
}
fun test9() {
    println("*********** Test 9 *************")
    val mapByAge: Map<Int, List<Hero>> =
        heroes.groupBy {hero -> hero.age }
    val (age, group) = mapByAge.maxBy {
            (_, group) -> group.size
    }!!
    println(age)
}
fun test8() {
    println("*********** Test 8 *************")
    println(heroes.any { hero ->
        hero.gender == Gender.FEMALE
    })
}
fun test7() {
    println("*********** Test 7 *************")
    println(heroes.all { hero ->
        hero.age < 50
    })
}
fun test6() {
    println("*********** Test 6 *************")
    println(heroes.maxBy { hero ->
        hero.age
    }?.name)
}
fun test5() {
    println("*********** Test 5 *************")
//    val (youngest, oldest) = heroes.partition { hero ->
//        hero.age < 30
//    }
    println(heroes.partition { hero ->
        hero.age < 30
    }.first.size)

//    println(oldest.size)
}

fun test4() {
    println("*********** Test 4 *************")
    println(heroes.filter {hero ->
        hero.age < 30
    }.size)
}
fun test3() {
    println("*********** Test 3 *************")
    println(heroes.map {hero ->
        hero.age
    }.distinct().size)
}

fun test2() {
    println("*********** Test 2 *************")
    println(heroes.firstOrNull { it.age == 30 }?.name)
}

fun test1() {
    println("*********** Test 1 *************")
    println(heroes.last().name)
}

fun main() {
    test1()
    test2()
    test3()
    test4()
    test5()
    test6()
    test7()
    test8()
    test9()
    test10()
    test11()
    test12()
    test12Better()
}

