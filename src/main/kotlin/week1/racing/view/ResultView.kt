package week1.racing.view

import week1.racing.GameRound
import week1.racing.RacingGame

class ResultView {
    fun printRounds(racingGame: RacingGame) {
        println("\n실행 결과\n")
        racingGame.gameRounds.forEach { round ->
            buildMessageForEachRound(round)
            println()
        }
    }

    fun printWinners(racingGame: RacingGame) {
        val winnerMessage = racingGame.getFinalWinnerNames().joinToString(separator = ", ")
        println(winnerMessage + "가 최종 우승했습니다.")
    }

    private fun buildMessageForEachRound(round: GameRound) {
        fun buildMessage(carName: String, positionCount: Int) = buildString {
            append(carName)
            append(" : ")
            append(PATH_DASH.repeat(positionCount))
        }

        round.records.forEach { (carName, positionCount) ->
            val message = buildMessage(carName, positionCount)
            println(message)
        }
    }

    companion object {
        private const val PATH_DASH = "-"
    }
}
