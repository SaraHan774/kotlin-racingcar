package week1.racing.view

import week1.racing.GameRound

class ResultView {

    fun printResult(rounds: List<GameRound>) {
        println("실행 결과")
        rounds.forEach { round ->
            round.records.forEach { positionCount ->
                val path = PATH_DASH.repeat(positionCount)
                println(path)
            }
            println()
        }
    }

    companion object {
        private const val PATH_DASH = "-"
    }
}
