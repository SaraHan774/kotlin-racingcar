package week1.step3.view

import week1.step3.domain.GameRound

class ResultView {
    private val pathDash = "-"

    fun printResult(rounds: List<GameRound>) {
        rounds.forEach { round ->
            round.records.forEach { positionCount ->
                repeat(positionCount) { print(pathDash) }
                println()
            }
            println()
        }
    }
}