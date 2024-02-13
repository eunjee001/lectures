package com.kkyoungs.lectures.chapter2
 fun main() {
     val a = fun(){ println("hello")}
     val c: Int = 10
     val b : (Int) -> Int= { it * 10 }
     val d = {i:Int, j : Int -> i * j}
     val f : (Int, String, Boolean) -> String = {_,b,_, ->b}

     hello(10, b)
}

fun hello (a:Int , b:(Int) -> Int){
    println(a)
    println(b(20))
}