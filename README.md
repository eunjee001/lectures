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
