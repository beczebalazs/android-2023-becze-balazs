package main.dictionary.interfaces

interface IDictionary {

    companion object {
        const val DICTIONARY_FILE =
            "/Users/balazsbecze/Egyetem/Android/android-2023-becze-balazs/kotlin-exercises/labor-02/src/main/dict.txt"
    }

    fun add(word: String): Boolean
    fun find(word: String): Boolean
    fun size(): Int
}