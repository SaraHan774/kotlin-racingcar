package step3

import kotlin.random.Random

fun main() {
    val inputView = InputView()
    val numCars = inputView.readNumCars()
    val numTries = inputView.readNumTries()

    val resultView = ResultView()
    resultView.printResult(numCars, numTries)
}

class InputView {
    fun readNumCars(): Int {
        println("자동차 대수는 몇 대 인가요?")
        val numCar = readLine()!!.toInt()
        return numCar
    }

    fun readNumTries(): Int {
        println("시도할 횟수는 몇 회 인가요?")
        val numTries = readLine()!!.toInt()
        return numTries
    }
}

class ResultView {
    fun printResult(numCars: Int, numTries: Int) {
        val cars = List(numCars) { RacingCar() }
        for (i in 0 until numTries) {
            println()
            cars.forEach {
                it.moveForward()
                println(it.path)
            }
        }
    }
}

class RacingCar {
    private var currentPosition = 1
    private val pathDash = "-"
    var path: String = pathDash
        private set

    fun moveForward() {
        if (getShouldMoveFromRandom()) {
            pathDash.repeat(++currentPosition).also { path = it }
        }
    }

    private fun getShouldMoveFromRandom(): Boolean {
        val randomUntil = 9
        val minForwardThreshold = 4
        return Random.nextInt(until = randomUntil) >= minForwardThreshold
    }
}