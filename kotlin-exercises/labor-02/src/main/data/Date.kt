package main.data

import java.time.LocalDate

data class SimpleDate(
    val year: Int = LocalDate.now().year,
    val month: Int = LocalDate.now().monthValue,
    val day: Int = LocalDate.now().dayOfMonth
)

val dateComparator = compareBy<SimpleDate>({ it.year }, { it.month }, { it.day })

fun SimpleDate.isLeap(): Boolean = when {
    year % 400 == 0 -> true
    year % 100 == 0 -> false
    else -> year % 4 == 0
}

fun SimpleDate.hasValidFormat(): Boolean {
    if (year > 2023 || month !in 1..12 || day !in 1..31) {
        return false
    }

    val maxDaysInMonth = when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        else -> if (isLeap()) 29 else 28
    }

    return day <= maxDaysInMonth
}

fun SimpleDate.toLocalDate() = LocalDate.of(year, month, day)

fun SimpleDate.subtractOneDay() = toLocalDate().minusDays(1)
