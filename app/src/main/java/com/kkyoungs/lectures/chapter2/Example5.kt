package com.kkyoungs.lectures.chapter2

fun main(){
    val person = Person("수지" ,25)
    val dog = Dog("로또", 4)

    println(person.toString())
    println(dog.toString())
    // name은 그대로 age만 변경
    println(dog.copy(age =3))

    val cat : Cat = BlueCat()
    when(cat){
        is BlueCat -> "blue"
        is RedCat -> "RED"
        is GreenCat -> "Green"
    }
}
class Person (val name : String, val age :Int)

data class Dog(val name:String, val age:Int)

//sealed class
sealed class Cat
class BlueCat : Cat()
class RedCat : Cat()
class GreenCat : Cat()

