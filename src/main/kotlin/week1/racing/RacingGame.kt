package week1.racing

class RacingGame(
    carNames: List<String>,
    private val numRounds: Int,
) {
    private val cars = carNames.map(::RacingCar)
    private val _gameRounds = mutableListOf<GameRound>()
    val gameRounds: List<GameRound> = _gameRounds

    fun start() {
        require(cars.isNotEmpty() && numRounds > 0) {
            "Game cannot be started! (cars.size = ${cars.size}, numRounds = $numRounds)"
        }

        repeat(numRounds) { round ->
            val positions = mutableListOf<Int>()
            cars.forEach { car ->
                car.moveForward()
                positions.add(car.currentPosition)
            }
            _gameRounds.add(GameRound(id = round + 1, records = positions))
        }
    }
}

data class GameRound(
    val id: Int,
    val records: List<Int>,
)
