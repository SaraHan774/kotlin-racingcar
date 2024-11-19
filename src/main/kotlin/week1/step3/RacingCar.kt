package week1.step3

import kotlin.random.Random

fun main() {
    val inputView = InputView()
    val numCars = inputView.readNumCars()
    val numTries = inputView.readNumTries()

    val racingGame = RacingGame(numCars, numTries)
    racingGame.start()

    val resultView = ResultView()
    resultView.printResult(racingGame.getResult())
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
    fun printResult(result: List<String>) {
        result.forEach {
            println()
            println(it)
        }
    }
}

class RacingGame(
    numCars: Int,
    private val numTries: Int,
) {
    private val cars = List(numCars) { RacingCar() }
    private val roundToPath = sortedMapOf(0 to "")

    fun start() {
        for (round in 0 until numTries) {
            cars.forEach { car ->
                car.moveForward()
                recordPath(round, car.path)
            }
        }
    }

    fun getResult(): List<String> {
        return roundToPath.map { it.value }
    }

    private fun recordPath(
        round: Int,
        path: String,
    ) {
        if (roundToPath[round] != null) {
            roundToPath[round] = roundToPath[round] + "\n" + path
        } else {
            roundToPath[round] = path
        }
    }
}

class RacingCar {
    private var currentPosition = 1
    private val pathDash = "-"
    var path: String = pathDash
        private set

    fun moveForward() {
        if (shouldMove()) {
            pathDash.repeat(++currentPosition).also { path = it }
        }
    }

    private fun shouldMove(): Boolean {
        val randomUntil = 9
        val minForwardThreshold = 4
        return Random.nextInt(until = randomUntil) >= minForwardThreshold
    }
}
