package week1.racing

import week1.racing.controller.RacingGameController
import week1.racing.view.InputView
import week1.racing.view.ResultView

fun main() {
    val racingGameController = RacingGameController(InputView(), ResultView())
    racingGameController.initGame()
    racingGameController.startGame()
    racingGameController.printGameResult()
}
