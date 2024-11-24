package week1.racing.view

import week1.racing.GameRound

class ResultView {
    fun printResult(rounds: List<GameRound>) {
        println("실행 결과")
        rounds.forEach { round ->
            buildMessageForEachRound(round)
            println()
        }
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
