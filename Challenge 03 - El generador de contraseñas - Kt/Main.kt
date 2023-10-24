/*
 * Escribe un programa que sea capaz de generar contraseñas de forma aleatoria.
 * Podrás configurar generar contraseñas con los siguientes parámetros:
 * - Longitud: Entre 8 y 16.
 * - Con o sin letras mayúsculas.
 * - Con o sin números.
 * - Con o sin símbolos.
 * (Pudiendo combinar todos estos parámetros entre ellos)
 */

fun generatePassword(length: Int = 8, withUpper: Boolean = false, withNumbers: Boolean = false, withSymbols: Boolean = false): String {
    val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val lower = "abcdefghijklmnopqrstuvwxyz"
    val numbers = "0123456789"
    val symbols = "!¡@#$%^&*=+/?"

    var characters: String = ""
    characters += lower
    if (withUpper) characters += upper
    if (withSymbols) characters += symbols
    if (withNumbers) characters += numbers

    var password: String = ""
    for (i in 0..<length) {
        password += characters.random()
    }

    return password

}

fun main(args: Array<String>) {
    println(
        generatePassword(
            12,
            false,
            withNumbers = false,
            withSymbols = false
        )
    )
}