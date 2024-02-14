package com.kkyoungs.lectures.chapter2

fun main(){
    println(Counter.count)
    Counter.countUp()
    Counter.countUp()
    println(Counter.count)

    Book.NAME

}

object Counter {
    init {
        println("카운터 초기화")
    }
    var count = 0
    fun countUp() {
        count ++
    }
}

class Book{
    companion object{
        const val NAME = "name"
    }
}