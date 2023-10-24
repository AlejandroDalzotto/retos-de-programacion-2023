/*
 * Escribe un programa que muestre cómo transcurre un juego de tenis y quién lo ha ganado.
 * El programa recibirá una secuencia formada por "P1" (Player 1) o "P2" (Player 2), según quien
 * gane cada punto del juego.
 *
 * - Las puntuaciones de un juego son "Love" (cero), 15, 30, 40, "Deuce" (empate), ventaja.
 * - Ante la secuencia [P1, P1, P2, P2, P1, P2, P1, P1], el programa mostraría lo siguiente:
 *   15 - Love
 *   30 - Love
 *   30 - 15
 *   30 - 30
 *   40 - 30
 *   Deuce
 *   Ventaja P1
 *   Ha ganado el P1
 * - Si quieres, puedes controlar errores en la entrada de datos.
 * - Consulta las reglas del juego si tienes dudas sobre el sistema de puntos.
 */

enum class Player {
    P1, P2
}

fun main() {
    println(playTennis(arrayOf()))
    println(playTennis(arrayOf(Player.P1, Player.P2, Player.P1)))
}

fun playTennis(sequence: Array<Player>): String {

    if (sequence.isEmpty()) return "Invalid sequence"

    var playerOnePoints = 0
    var playerTwoPoints = 0

    for (player in sequence) {

        when (player) {
            Player.P1 -> {
                playerOnePoints += if (playerOnePoints >= 30) 10 else 15
                if (playerOnePoints == 60) break
                announceScore(playerOnePoints, playerTwoPoints)
            }

            Player.P2 -> {
                playerTwoPoints += if (playerTwoPoints >= 30) 10 else 15
                if (playerTwoPoints == 60) break
                announceScore(playerOnePoints, playerTwoPoints)
            }
        }
    }

    return if (playerOnePoints > playerTwoPoints) "Player 1 wins" else "Player 2 wins"
}

private fun announceScore(playerOnePoints: Int, playerTwoPoints: Int) {
    val playerOneScore = if (playerOnePoints == 0) "Love" else playerOnePoints
    val playerTwoScore = if (playerTwoPoints == 0) "Love" else playerTwoPoints

    println("$playerOneScore - $playerTwoScore")
    
    if (playerOnePoints == 50 || playerTwoPoints == 50) {
        println("Player ${if (playerOnePoints == 50) 1 else 2} advantage")
    } else if (playerOnePoints == playerTwoPoints) {
        println("Deuce")
    }
}