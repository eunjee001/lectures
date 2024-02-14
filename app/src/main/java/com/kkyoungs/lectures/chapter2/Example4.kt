package com.kkyoungs.lectures.chapter2

// 타입 지정 꼭 필수
lateinit var text : String

// 호출 하는 시점에서 초기화
val test : Int by lazy {
    println("초기화중,,")
    100
}
/**
 * lateinit var age : Int -> Integer
 * Int형은 선언 못함 ==> Integer
 */
fun main(){
    println("메인 함수 실행")
    println("초기화 한 값 $test")
    println("두번째 호출 $test")

    text = "name"

    println(text)
}