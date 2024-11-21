package week1.racing

import week1.racing.view.InputView
import week1.racing.view.ResultView

fun main() {
    val inputView = InputView()
    val numCars = inputView.readIntSafelyOrZero(InputView.HOW_MANY_CARS_MESSAGE)
    val numTries = inputView.readIntSafelyOrZero(InputView.HOW_MANY_ROUNDS_MESSAGE)

    val racingGame = RacingGame(numCars, numTries)
    racingGame.start()

    val resultView = ResultView()
    resultView.printResult(racingGame.gameRounds)
}
