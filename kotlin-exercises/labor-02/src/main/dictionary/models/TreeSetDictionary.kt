package main.dictionary.models

import main.dictionary.interfaces.IDictionary
import java.io.File
import java.util.*

object TreeSetDictionary : IDictionary {
    val words = TreeSet<String>()

    init {
        val file = File(IDictionary.DICTIONARY_FILE)
        val lines = file.readLines()
        words.addAll(lines)
    }

    override fun add(word: String): Boolean {
        return true
    }

    override fun find(word: String): Boolean {
        val wordSearch = words.contains(word)
        return wordSearch
    }

    override fun size(): Int {
        return words.size
    }

}