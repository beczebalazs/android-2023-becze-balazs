package main

import kotlin.random.Random

// f3
fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2 until n) {
        if (n % i == 0) return false
    }
    return true
}

//f4
fun encode(input: String): String {
    val offset = 3
    return input.map { it + offset }.joinToString(separator = "")
}

fun decode(input: String): String {
    val offset = 3
    return input.map { it - offset }.joinToString(separator = "")
}

fun messageCoding(msg: String, func: (String) -> String): String {
    return func(msg)
}

//f5
fun printEvenNumbers(numbers: List<Int>) = numbers.filter { it % 2 == 0 }.forEach { println(it) }

fun main() {
    // feladat 1
    println("Feladat 1:")
    val a = 2
    val b = 3
    val sum = a + b
    println("$a + $b = $sum")

    //feladat 2
    println("--------------------------------------------------")
    println("Feladat 2:")
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    for (day in daysOfWeek) {
        println(day)
    }

    println("Days starting with 'T':")
    daysOfWeek.filter { it.startsWith('T') }.forEach { println(it) }

    println("Days containing 'e':")
    daysOfWeek.filter { 'e' in it }.forEach { println(it) }

    println("Days with length of 6:")
    daysOfWeek.filter { it.length == 6 }.forEach { println(it) }

    //feladat 3
    println("--------------------------------------------------")
    println("Feladat 3:")
    val start = 10
    val end = 50

    println("Prime numbers between $start and $end:")
    for (number in start..end) {
        if (isPrime(number)) {
            println(number)
        }
    }

    //feladat 4
    println("--------------------------------------------------")
    println("Feladat 4:")
    val originalMessage = "Hello, Kotlin!"

    val encodedMessage = messageCoding(originalMessage, ::encode)
    println("Encoded Message: $encodedMessage")

    val decodedMessage = messageCoding(encodedMessage, ::decode)
    println("Decoded Message: $decodedMessage")

    //feladat 5
    println("--------------------------------------------------")
    println("Feladat 5:")
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    printEvenNumbers(list)

    //feladat 6
    println("--------------------------------------------------")
    println("Feladat 6:")
    val numbers = listOf(1, 2, 3, 4, 5)
    val dayOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    val doubledNumbers = numbers.map { it * 2 }
    println("Doubled Numbers: $doubledNumbers")

    val capitalizedDays = dayOfWeek.map { it.uppercase() }
    println("Capitalized Days: $capitalizedDays")

    val firstCharOfDays = daysOfWeek.map { it[0].uppercase() }
    println("First Characters of Days (Capitalized): $firstCharOfDays")

    val lengthOfDays = daysOfWeek.map { it.length }
    println("Length of Days: $lengthOfDays")

    val averageLengthOfDays = lengthOfDays.average()
    println("Average Length of Days: $averageLengthOfDays")

    //feladat 7
    println("--------------------------------------------------")
    println("Feladat 7:")
    val daysOfWeek2 = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    val mutableDaysOfWeek = daysOfWeek2.toMutableList()

    mutableDaysOfWeek.removeAll { 'n' in it }
    println(mutableDaysOfWeek)

    mutableDaysOfWeek.withIndex().forEach { println("Item at ${it.index} is ${it.value}") }

    mutableDaysOfWeek.sort()
    println(mutableDaysOfWeek)

    //feladat 8
    println("--------------------------------------------------")
    println("Feladat 8:")
    val randomArray = Array(10) { Random.nextInt(0, 101) }

    println("Original Array:")
    randomArray.forEach { println(it) }

    val sortedArray = randomArray.sorted()
    println("Sorted Array:")
    sortedArray.forEach { println(it) }

    val containsEven = randomArray.any { it % 2 == 0 }
    println("Array contains even number: $containsEven")

    val allEven = randomArray.all { it % 2 == 0 }
    println("All numbers are even: $allEven")

    val average = randomArray.average()
    println("Average of numbers: $average")
}