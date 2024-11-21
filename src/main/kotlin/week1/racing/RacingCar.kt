package week1.racing

import kotlin.random.Random

class RacingCar {
    var currentPosition = 1
        private set

    fun moveForward(shouldMove: Boolean = shouldMove()) {
        if (shouldMove) {
            ++currentPosition
        }
    }

    private fun shouldMove(): Boolean {
        val randomUntil = 9
        val minForwardThreshold = 4
        return Random.nextInt(until = randomUntil) >= minForwardThreshold
    }
}
