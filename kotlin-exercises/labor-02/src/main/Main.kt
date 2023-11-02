package main

import main.dictionary.interfaces.IDictionary
import main.dictionary.models.HashSetDictionary
import main.dictionary.models.ListDictionary
import main.dictionary.models.TreeSetDictionary

fun main(args: Array<String>) {
    if (!testDictionary(ListDictionary, "List")) return
    if (!testDictionary(HashSetDictionary, "HashSet")) return
    if (!testDictionary(TreeSetDictionary, "TreeSet")) return
}

fun testDictionary(dictionary: IDictionary, dictionaryType: String): Boolean {
    println("Testing $dictionaryType Dictionary")
    println("Number of words: ${dictionary.size()}")
    while (true) {
        print("What to find? (type 'quit' to stop) ")
        val word = readLine()
        if (word.equals("quit", ignoreCase = true)) {
            return false
        }
        println("Result: ${word?.let { dictionary.find(it) }}")
    }
}
