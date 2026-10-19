package com.example.unit3kotlinpractice

fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
    val question2 = Question<Boolean>("The sky is green. True or false", false, "easy")
    val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")

    println("${question1.questionText} -> ${question1.answer}")
    println("${question2.questionText} -> ${question2.answer}")
    println("${question3.questionText} -> ${question3.answer}")
}