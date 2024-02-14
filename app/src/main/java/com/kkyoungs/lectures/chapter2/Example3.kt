package com.kkyoungs.lectures.chapter2

fun main() {
    val a = 3
    a. let{

    }
    val user = User("굠잉", 10, true)

    // 수신객체.let
    val age = user.let{
        user.age
    }
    println(age)

    val kid = User("로또", 4,false)
    val kidAge = kid.run {
        age
    }
    println(kidAge)

    val kidName = kid.apply {
        name
    }
    println(kidName)
    val female = User("꼬미", 1 , true, false)
    val femaleValue = female.apply {
        hasGlasses = false
    }

    println(femaleValue.hasGlasses)

    val male = User("겸" , 25, false, true)
    val maleValue = male.also{
        user -> user.name
        user.hasGlasses = false
    }
    println(maleValue.hasGlasses)

}

class User(
    val name : String,
    val age : Int,
    val gender: Boolean,
    var hasGlasses : Boolean = true
)

