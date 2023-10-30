/*
 * Crea 3 funciones, cada una encargada de detectar si una cadena de
 * texto es un heterograma, un isograma o un pangrama.
 * - Debes buscar la definición de cada uno de estos términos.
 */

fun isHeterogram(word: String): Boolean {

    val lettersMapped = mutableMapOf<Char, Int>()

    for (char in word) {
        if (!lettersMapped.keys.contains(char)) {
            lettersMapped[char] = 1
            continue
        }
        lettersMapped[char] = lettersMapped[char]!! + 1
    }
    return lettersMapped.filter { it.value > 1 }.isEmpty()
}

fun isIsogram(word: String): Boolean {
    val lettersMapped = mutableMapOf<Char, Int>()

    for (char in word) {
        if (!lettersMapped.keys.contains(char)) {
            lettersMapped[char] = 1
            continue
        }
        lettersMapped[char] = lettersMapped[char]!! + 1
    }
    val mostRepeated = lettersMapped.values.max()

    return lettersMapped.filter { it.value == mostRepeated && it.value > 1 }.size == lettersMapped.size
}

fun isPangram(value: String): Boolean {
    val alphabet = "abcdefghijklmnñopqrstuvwxyz".toCharArray()
    val lettersChecked = mutableListOf<Char>()
    val phrase = value.lowercase()

    for (letter in phrase) {
        if (alphabet.contains(letter) && !lettersChecked.contains(letter)) {
            lettersChecked.add(letter)
        }
    }
    return lettersChecked.size == alphabet.size
}

fun main() {
    println(isHeterogram("murciélago")) // Return: true
    println(isHeterogram("anna")) // Return: false

    println(isIsogram("murciélago")) // Return: false
    println(isIsogram("anna")) // Return: true

    println(isPangram("Benjamín pidió una bebida de kiwi y fresa. Noé, sin vergüenza, la más exquisita champaña del menú"))
}