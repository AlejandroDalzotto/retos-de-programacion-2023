/*
 * Escribe un programa que, dado un número, compruebe y muestre si es primo,
 * fibonacci y par.
 * Ejemplos:
 * - Con el número 2, nos dirá: "2 es primo, fibonacci y es par"
 * - Con el número 7, nos dirá: "7 es primo, no es fibonacci y es impar"
 */

fun isFibonacci(number: Int): Boolean {

    if (number == 0 || number == 1) return true

    var index = 1
    var lastIndex = 0
    var sum = 0
    while (sum <= number) {
        sum = index + lastIndex
        lastIndex = index
        index = sum
        if (sum == number) {
            return true
        }
    }
    return false
}

fun isEven(number: Int): Boolean {
    return number % 2 == 0
}

fun isPrime(number: Int): Boolean {
    if (number <= 1) return false
    if (number == 2) return true
    if (number % 2 == 0) return false

    var divider = 3
    while (divider * divider <= number) {
        if (number % divider == 0) {
            return false
        }
        divider += 2
    }

    return true
}

fun primeFibonacciAndEven(number: Int): String {

    var result = "$number"
    result += if (isPrime(number)) " it's prime, " else " isn't prime, "
    result += if (isFibonacci(number)) "fibonacci " else "not fibonacci "
    result += if (isEven(number)) "and even." else "and odd."

    return result
}

fun main() {
    println(primeFibonacciAndEven(2))
    println(primeFibonacciAndEven(3))
    println(primeFibonacciAndEven(21))
    println(primeFibonacciAndEven(357))
}