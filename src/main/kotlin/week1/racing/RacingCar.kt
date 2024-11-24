package week1.racing

import kotlin.random.Random

class RacingCar(val name: String) {
    init {
        require(name.length <= MAX_CAR_NAME_LENGTH) {
            "Car name is too long ! (max length = $MAX_CAR_NAME_LENGTH, current = ${name.length})"
        }
    }

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

    companion object {
        private const val MAX_CAR_NAME_LENGTH = 5
    }
}
