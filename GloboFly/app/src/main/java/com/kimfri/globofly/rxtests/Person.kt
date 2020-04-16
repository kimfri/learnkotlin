package com.kimfri.globofly.rxtests

import io.reactivex.rxjava3.core.Observable

data class Person(val name: String) {
    fun getFitnessResult(): Observable<Fitness>? {
        return Observable.create<Fitness> {
            it.onNext(Fitness(this))
            it.onComplete()
        }
    }
}

data class Fitness(val person: Person) {
    val caloriesBurnedToday = 3
}