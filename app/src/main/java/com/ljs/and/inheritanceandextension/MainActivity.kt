package com.ljs.and.inheritanceandextension

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 부모 클래스 직접 호출
        var parent = Parent()
        parent.sayHello()
        // 2. 자식 클래스 호출해서 사용하기
        var child = Child()
        child.myHello()

        testStringExtension()
    }

    // String 익스텐션을 테스트
    fun testStringExtension(){
        var original = "Hello"
        var added = " Guys~"
        // plus 메서드를 사용해서 문자열을 더할 수 있음
        Log.d("Extension", "added를 더한 값은 ${original.plus(added)}")
    }

}

// 상속연습
open class Parent{
    var hello:String = "안녕하세요"
    fun sayHello(){
        Log.d("Extension", "${hello}")
    }
}

class Child: Parent(){
    fun myHello(){
        hello = "Hello"
        sayHello()
    }
}

// 메서드 오버라이드 연습
open class BaseClass{
    open fun opened(){

    }
    fun notOpend(){

    }
}

class ChildClass:BaseClass(){
    override fun opened() {

    }

//    override fun notOpend(){  // 부모 메서드에 오픈 안되있어서 에러
//
//    }
}

// 프로퍼티 오버라이드 연습
open class BaseClass2{
    open var opened:String = "I am"
}
class ChildClass2:BaseClass2(){
    override  var opened:String = "You are"
}
fun String.plus(word:String):String{
    return this+word
}

