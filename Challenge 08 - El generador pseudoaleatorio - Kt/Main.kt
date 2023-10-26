/*
 * Crea un generador de números pseudoaleatorios entre 0 y 100.
 * - No puedes usar ninguna función "random" (o semejante) del
 *   lenguaje de programación seleccionado.
 *
 * Es más complicado de lo que parece...
 */

fun getRandomNumber(): Long {
    return System.currentTimeMillis() % 100
}

fun main() {
    val number = getRandomNumber()
    println(number)
}