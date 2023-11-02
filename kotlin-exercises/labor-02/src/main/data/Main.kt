package main.data

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val validSimpleDates = ArrayList<SimpleDate>()
    val random = Random()

    while (validSimpleDates.size < 10) {
        val year = random.nextInt(3000) + 1
        val month = random.nextInt(12) + 1
        val day = random.nextInt(31) + 1

        val simpleDate = SimpleDate(year, month, day)

        if (simpleDate.hasValidFormat()) {
            validSimpleDates.add(simpleDate)
        } else {
            println("Invalid date: $simpleDate")
        }
    }

    println("\nValid Dates:")
    validSimpleDates.forEach { println(it) }

    println("\nValid Dates sorted by natural order:")
    validSimpleDates.sortBy { it.toLocalDate() }
    validSimpleDates.forEach { println(it) }

    println("\nValid Dates sorted by descending order:")
    validSimpleDates.sortByDescending { it.toLocalDate() }
    validSimpleDates.forEach { println(it) }

    println("\nValid Dates sorted by custom comparator:")
    validSimpleDates.sortWith(dateComparator)
    validSimpleDates.forEach { println(it) }
}
