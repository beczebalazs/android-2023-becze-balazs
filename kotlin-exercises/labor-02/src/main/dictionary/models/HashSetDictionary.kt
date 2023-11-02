package main.dictionary.models

import main.dictionary.interfaces.IDictionary
import java.io.File

object HashSetDictionary : IDictionary {
    val words = HashSet<String>()

    init {
        val file = File(IDictionary.DICTIONARY_FILE)
        val lines = file.readLines()
        words.addAll(lines)
    }

    override fun add(word: String): Boolean {
        return words.add(word)
    }

    override fun find(word: String): Boolean {
        return words.contains(word)
    }

    override fun size(): Int {
        return words.size
    }
}