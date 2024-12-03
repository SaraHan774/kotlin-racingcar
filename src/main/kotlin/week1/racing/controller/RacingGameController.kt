package week1.racing.controller

import week1.racing.domain.RacingGame
import week1.racing.view.InputView
import week1.racing.view.ResultView

class RacingGameController {
    fun play() {
        val inputView = InputView()
        val resultView = ResultView()

        val carNames = inputView.readCarNames(InputView.ENTER_CAR_NAMES_MESSAGE)
        val numRounds = inputView.readIntSafelyOrZero(InputView.HOW_MANY_ROUNDS_MESSAGE)
        val game = RacingGame(carNames = carNames, numRounds = numRounds)

        game.start()
        resultView.printRounds(game.gameRounds)

        val finalWinner = game.getWinner()
        resultView.printWinners(finalWinner)
    }
}
