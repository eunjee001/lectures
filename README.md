# 코틀린 기초
<b> 코틀린의 특징 </b>
* 실용성  
* 간결성  
* 안정성  
👉 예를 들어 nullpoint exception 에 대한 안정성  
* 상호운용성   
👉 자바언어로 만들어진거를 코틀린으로 바꾸거나 또 반대로 코틀린을 자바로 변환할 수 있는 상호운용성이 있다.

## 1. 함수
Unit type은 자바의 void와 같은 역할을 합니다. return을 명시적으로 넣지 않아도된다.
예를 들어서 main 함수 같은 것을 unit 타입이라고 함.

ex)  
```kotlin
fun main(){
}
```
또, 코틀린은 간결하게 코드를 작성할 수 있다는 장점이 있다.  
Int를 타입으로 하면 return 값이 필요하다 하지만 아래와 코드와 같이 작성 할 수 있다.

ex)
```kotlin
fun times(a:Int, b: Int) = a * b
```

## 2. 변수
- val 👉 value (값)
- var 👉 variable (변경가능한)

## 3. class
property에 open 을 붙이면 해당 클래스를 상속받은 함수에서 override 해서 쓸 수 있다.  
또한 함수를 상속 받으려면 class 앞에도 open 붙여야함  
부생성자를 만들 수 있는데 constructor 을 붙이면됨  

```kotlin
fun main(){
    var user = User ("조은경")
    println (user.age)
    Kid("로또", 4, "male")
}

open class User(open val name : String, open var age : Int = 100)

class Kid (override val name : String, override var age : Int) : User(name, age){
    var gender : String = "female"

    init {
        println("초기화중")
    }

    constructor(name: String, age:Int, gender: String) : this(name, age){
        this.gender = gender
        println("부생성자 호출")
    }
}

/**
 *출력
 *  
 *100  
 *초기화중  
 *부생성자 호출
 */
```


init 이 먼저 출력되고 그다음 constructor이 호출되는 것을 확인 할 수 있다.


## 4. 조건식

- if 문은 중괄호 생략 가능  
ex)  
```kotlin
val result = if(a < b) b else a 
```

- when (코틀린에만 있음)  
ex)
```kotlin 
when(dayOfWeek){
    "월" ->{}
    "화" ->{}
    "수" ->{}
    "목" ->{}
    "금" ->{}
    "토" ->{}
    "일" ->{}
}  
```  

## 5. 반복문

ex) for 문 
``` kotlin
for (i in 1..10){
    print(i)
    print(".")
}

// 1..10 = IntRange(1,10) 이렇게 할 수도 있다 (1부터 10포함!)
// 1 until 10  ==> 이거는 1부터 10까지! (10 포함 안됨)

for(i in 1..10 step(2)){
    // 이렇게 하면 홀수 만 찍힌다.
}

for (i in 10 downTo 1){
    // 이렇게 하면 거꾸로 호출 10 9 8 7 ...
}

```  

ex) while 문  
``` kotlin
while (c < 11){
    println(c)
    c++
}

```  

## 6. 컬렉션 (list, map, set)  

- list  : mutableList, unmutableList 이렇게 두가지 가 있다.(가변 , 불변)  
```kotlin
val list = mutableListOf(1,2,3,4,5)
list.add(6)
list.addAll(listOf(7,8,9))

println(list.joinToString(","))

// 출력 : 1,2,3,4,5,6,7,8,9
```  

- map에도 가변 불변이 있다.
``` kotlin
val map = mapOf((1 to "안녕"), (2 to "바이"))
val map1 = mutalbeMapOf((1 to "안녕"), (2 to "바이"))
map1[3] = "용"
map1[100] = "호이"
```  

## 7. NULL
ex)  
``` kotlin 
//이렇게 할 수 있음
val result = nickname? : "값이 없음"
val size = nickname?.length
```  

## 8. 타입체크와 캐스팅  
is라는 키워드를 통해서 이 타입이 맞는지 아닌지 판단.  
``` kotlin
if(a is String){
    "문자열"
}else if(a is Int){
    "숫자"
}
```  
또한 as라는 키워드를 통해서 Int형을 String Type으로 변환하고싶을때 그냥 하면 compile에러 나니까 '?'를 붙여서 실행  
→ null 출력  
``` kotlin
val result = a as? String
println(result)

// 출력 : null
```

## 9. String Template  
굳이 toString 하지 않고 $를 붙이면 간단하게 해결  
ex)
``` kotlin
val a = 10
val name = "로또"
val isHigh = true
println("$a ${name.length} $isHigh")

//출력 : 10 2 true
```

# 코틀린 중급

## 1. 람다 함수
1. 익명 함수  
```kotlin   
val a = fun(){ println("hello")}
```
2. 변수 처럼 사용되서, 함수의 argument, return
```kotlin   
val b : (Int) -> Int= { it * 10 }
println(b(10))

// 출력 : 100
```

3. 한번 사용 되고, 재사용 되지 않는 함수
- SAM : Single Abstract Method(단일 추상 메소드)  
```kotlin  
view.setOnClickListener { println("안녕") } 
```  

## 2. 확장 함수(Extension function)  
기존에 정의 되어 있는 클래스에 함수를 추가하는 기능
```kotlin
fun main() {
    val test = Test()
    Test().hello()
    test.hi()
    
}

fun Test.hi() = println("하이")

class Test(){
    fun hello() = println("안녕")
    fun bye() = println("잘가")
}  
```    

## 3. Scope Function (범위 지정 함수)
- 코틀린 표준 라이브러리에서 제공하는 확장함수
- 목적 : 간결, 명로, 유지보수 용이성
- 객체의 컨텍스트 내에서, 실행 가능한 코드 블럭을 만드는 함수
- 수신객체 : 확장 함수가 호출되는 대상이 되는 값
- 수신객체지정 람다 : 수신객체 명시하지 않고, 람다 본문 안에서 해당 객체의 메서드를 호출 할 수 있게 하는 것

<let, run, apply, also, with>
1. let : Null 체크 해야할 때, 지역변수를 명시적으로 표현해야 할 때
수신객체.let {it->... 마지막줄에서 return !}

```kotlin
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
}

class User(
    val name : String,
    val age : Int,
    val gender: Boolean
)

// 출력 : 10

```  

2. run : 객체 초기화 할 때 사용 : 객체를 초기화 하고 리턴 값이 있을 때
수신객체.run{this->.. 마지막 줄 return}
```kotlin
    val kid = User("로또", 4,false)
    val kidAge = kid.run {
        age
    }
    println(kidAge)

// 출력 : 4

```

3. apply : 객체 초기화
수신객체.apply{.. return 값이 수신객체(자기자신)}
```kotlin
fun main(){
 val female = User("꼬미", 1 , true, false)
    val femaleValue = female.apply {
        hasGlasses = false
    }

    println(femaleValue.hasGlasses)
}

class User(
    val name : String,
    val age : Int,
    val gender: Boolean,
    var hasGlasses : Boolean = true
)
```
4. also : 수신 객체를 명시적으로 사용하고 싶을 때, 로그를 남길 때
수신객체.alse{it->.. return 값이 수신객체(자기자신)
```kotlin
val male = User("겸" , 25, false, true)
    val maleValue = male.also{
        user -> user.name
        user.hasGlasses = false
    }
    println(maleValue.hasGlasses)
```
👉 also 와 apply 차이점
also는 로그남기는 용으로 사용하면 좋고, apply는 초기화 할 때 사용하면 좋다.

5. with : 객체 초기화, 람다 리턴 값이 필요 없을 때
with(수신객체){마지막줄 return}
```kotlin
  val result = with(male){
        hasGlasses = false
        true
    }
    println(result)
```

## 4. 초기화 지연 (lateinit, lazy)
- 정의 : 변수를 선언할 때, 값을 지정하지 않고, 나중에 지정할 수 있는 방법
- 목적 : 메모리를 효율적으로 사용하기 위해서, null safe 한 value를 사용하기 위해서
- lateinit, var
    - 변수 타입을 지정해줘야함
    - 선언 후 나중에 초기화해도 됨
    - primitive 타입은 사용할 수 없음(예를들어 Int --> Integer)
- lazy, val
    - 선언과 동시에 초기화
    - 호출 시점에 초기화 이뤄짐

```kotlin
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

    /*
    [출력] 
    
    메인 함수 실행
    초기화중,,
    초기화 한 값 100
    두번째 호출 100
    name
     */
```


## data, sealed class
- Data class : 데이터를 담기 위한 클래스
  - toStirng(), hasCode(), equals(), copy() 메서드 자동 생성(override 하면, 직접 구현한 코드 사용)
  - 1개 이상의 프로퍼티(접근자(getter/setter)를 사용해 접근하는 것)가 있어야 함
  - 데이터 클래스는 abstract, open, sealed, inner를 붙일 수 없음
  - 상속 불가능
```kotlin
  fun main(){
      val person = Person("수지" ,25)
      val dog = Dog("로또", 4)
  
      println(person.toString())
      println(dog.toString())
      // name은 그대로 age만 변경
      println(dog.copy(age =3))
  }
  class Person (val name : String, val age :Int)
  
  data class Dog(val name:String, val age:Int)

  /* 출력
  com.kkyoungs.lectures.chapter2.Person@5e481248
  Dog(name=로또, age=4)
  Dog(name=로또, age=3)
   */
```

- Sealed class : 추상 클래스로 상속 받은 자식 클래스의 종류 제한
  - 컴파일러가 sealed 클래스의 자식 클래스가 어떤 것 인지 암
  - when과 함께 쓰일 때 장점
  - else 쓰지 않아도 됨

  ```kotlin
  fun main(){
    val cat : Cat = BlueCat()
    when(cat){
      is BlueCat -> "blue"
      is RedCat -> "RED"
      is GreenCat -> "Green"
    }
  }
  
  sealed class Cat
  class BlueCat : Cat()
  class RedCat : Cat()
  class GreenCat : Cat()
  ```
  
## Object, Companion object
- object : 클래스를 정의함과 동시에 객체 생성
  - 싱글톤을 쉽게 만들 수 있는 키워드
  - 생성자 사용 불가
  - 프로퍼티, 메서드, 초기화 블록 사용가능
  - 다른 클래스나, 인터페이스를 상속받을 수 있음
  - 에러 코드 정의할 때 많이 사용
```kotlin
fun main(){
    Counter
    println(Counter.count)
    Counter.countUp()
    Counter.countUp()
    println(Counter.count)

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

/**
 * 출력
 * 카운터 초기화
 * 0
 * 2
 */
```
- Companion object 동반 객체
  - java의 static 과 동일한 역할
  - 클래스 내에 하나만 생성 가능

```kotlin
  class Book{
      companion object{
          const val NAME = "name"
      }
  }

    fun main(){
      Book.NAME
    }
```