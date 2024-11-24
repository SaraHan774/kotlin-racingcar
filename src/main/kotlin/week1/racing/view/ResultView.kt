package week1.racing.view

import week1.racing.GameRound
import week1.racing.getMaxDistanceRecords

class ResultView {
    fun printResult(rounds: List<GameRound>) {
        println("\n실행 결과\n")

        rounds.forEach { round ->
            buildMessageForEachRound(round)
            println()
        }

        val winnerMessage = rounds.getMaxDistanceRecords().joinToString(separator = ", ") { it.name }
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
