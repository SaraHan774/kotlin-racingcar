package week1.step3.view

import week1.step3.GameRound

class ResultView {

    fun printResult(rounds: List<GameRound>) {
        rounds.forEach { round ->
            round.records.forEach { positionCount ->
                repeat(positionCount) { print(PATH_DASH) }
                println()
            }
            println()
        }
    }

    companion object {
        private const val PATH_DASH = "-"
    }
}
