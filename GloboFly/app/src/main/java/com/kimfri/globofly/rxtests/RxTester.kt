package com.kimfri.globofly.rxtests

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


fun main() {
    test1()
    test2()
}

fun test1() {
    Observable.fromArray("Kim", "Maria", "Wille", "Theo")
        .subscribe { onNext ->
            println("name: $onNext")
        }

    Observable.fromArray("Kim", "Maria", "Wille", "Theo")
        .subscribeOn(Schedulers.newThread())
        .filter { name ->
            name.contains('K')
        }
        .observeOn(Schedulers.io())
        .map {
            it + " Fritzon-Ölander"
        }
        .subscribe { name ->
            println("name> $name")
        }
}

fun test2() {
    val person = Person("Kim")
    println("1. Person: ${person.name}")
    val personObservable = Observable.just(person)
    val fitnessObservable = personObservable
        .flatMap { person ->
            person.getFitnessResult()
        }.filter{
            it.caloriesBurnedToday == 3
        }
        .subscribe { fitness ->
            println("Fitness:${fitness.caloriesBurnedToday}, person: ${fitness.person.name}")
        }

}

