package main.extensions

fun main(args: Array<String>) {
    val fullName = "Becze Balazs"
    println(fullName.toMonogram())
    val fruitList = listOf("apple", "pear", "plum", "strawberry")
    println(fruitList.concatenate("#"))
    println(fruitList.findLongest())
}

fun String.toMonogram(): String = this.split("\\s+".toRegex()).mapNotNull { it.firstOrNull()?.toString() }.joinToString("")

fun List<String>.concatenate(delimiter: String): String = this.joinToString(delimiter)

fun List<String>.findLongest(): String = this.maxByOrNull { it.length } ?: ""
