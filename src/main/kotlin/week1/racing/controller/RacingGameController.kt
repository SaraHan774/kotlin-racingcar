package week1.racing.controller

import week1.racing.domain.RacingGame
import week1.racing.view.InputView
import week1.racing.view.ResultView

class RacingGameController(
    private val inputView: InputView,
    private val resultView: ResultView,
) {
    private lateinit var game: RacingGame

    fun initGame() {
        val carNames = inputView.readCarNames(InputView.ENTER_CAR_NAMES_MESSAGE)
        val numRounds = inputView.readIntSafelyOrZero(InputView.HOW_MANY_ROUNDS_MESSAGE)
        game = RacingGame(carNames = carNames, numRounds = numRounds)
    }

    fun startGame() {
        game.start()
    }

    fun printGameResult() {
        resultView.printRounds(game)
        resultView.printWinners(game)
    }
}