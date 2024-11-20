package week1.step3

import week1.step3.racing.RacingGame
import week1.step3.view.InputView
import week1.step3.view.InputView.Companion.HOW_MANY_CARS_MESSAGE
import week1.step3.view.InputView.Companion.HOW_MANY_TRIES_MESSAGE
import week1.step3.view.ResultView

fun main() {
    val inputView = InputView()
    val numCars = inputView.readIntSafelyOrZero(HOW_MANY_CARS_MESSAGE)
    val numTries = inputView.readIntSafelyOrZero(HOW_MANY_TRIES_MESSAGE)

    val racingGame = RacingGame(numCars, numTries)
    racingGame.start()

    val resultView = ResultView()
    resultView.printResult(racingGame.gameRounds)
}
