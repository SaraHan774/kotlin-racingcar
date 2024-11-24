package week1.racing

class RacingCar(
    val name: String,
    private val carMovementDecider: MovementDecider
) {
    init {
        require(name.length <= MAX_CAR_NAME_LENGTH) {
            "Car name is too long ! (max length = $MAX_CAR_NAME_LENGTH, current = ${name.length})"
        }
    }

    var currentPosition = 1
        private set

    fun moveForward() {
        if (carMovementDecider.shouldMove()) {
            ++currentPosition
        }
    }

    companion object {
        private const val MAX_CAR_NAME_LENGTH = 5
    }
}
