/*
 * Crea un programa que calcule quien gana más partidas a piedra,
 * papel, tijera, lagarto, spock.
 * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 * - La función recibe un listado que contiene pares, representando cada jugada.
 * - El par puede contener combinaciones de "🗿" (piedra), "📄" (papel),
 *   "✂️" (tijera), "🦎" (lagarto) o "🖖" (spock).
 * - Ejemplo. Entrada: [("🗿","✂️"), ("✂️","🗿"), ("📄","✂️")]. Resultado: "Player 2".
 * - Debes buscar información sobre cómo se juega con estas 5 posibilidades.
 */

enum class GameChoice(val dir: String) {
    ROCK("\uD83D\uDDFF"),
    LIZARD("\uD83E\uDD8E"),
    SCISSORS("✂\uFE0F"),
    PAPER("\uD83D\uDCC4"),
    SPOCK("\uD83D\uDD96");

    fun getConfront(): Array<GameChoice> {
        return when (this) {
            ROCK -> arrayOf(SCISSORS, LIZARD)
            LIZARD -> arrayOf(SPOCK, PAPER)
            SCISSORS -> arrayOf(PAPER, LIZARD)
            PAPER -> arrayOf(ROCK, SPOCK)
            SPOCK -> arrayOf(SCISSORS, ROCK)
        }
    }
}

fun play(values: Array<Pair<GameChoice, GameChoice>>): String {
    var playerOne = 0
    var playerTwo = 0

    values.forEach {
        if (it.first.getConfront().contains(it.second)) playerOne++
        if (it.second.getConfront().contains(it.first)) playerTwo++
    }

    return when {
        playerOne > playerTwo -> "Player 1"
        playerOne < playerTwo -> "Player 2"
        else -> "Tie"
    }
}

fun main(args: Array<String>) {
    println(
        play(
            arrayOf(
                Pair(GameChoice.ROCK, GameChoice.SCISSORS),
                Pair(GameChoice.SCISSORS, GameChoice.ROCK),
                Pair(GameChoice.PAPER, GameChoice.SCISSORS),
                Pair(GameChoice.LIZARD, GameChoice.SPOCK),
                Pair(GameChoice.SPOCK, GameChoice.PAPER)
            )
        )
    )
}