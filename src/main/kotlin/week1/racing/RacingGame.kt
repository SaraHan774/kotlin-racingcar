package week1.racing

class RacingGame(
    numCars: Int,
    private val numTries: Int,
) {
    private val cars = List(numCars) { RacingCar() }
    private val _gameRounds = mutableListOf<GameRound>()
    val gameRounds: List<GameRound> = _gameRounds

    fun start() {
        for (round in 0 until numTries) {
            val positions = mutableListOf<Int>()
            cars.forEach { car ->
                car.moveForward()
                positions.add(car.currentPosition)
            }
            _gameRounds.add(GameRound(id = round, records = positions))
        }
    }
}

data class GameRound(
    val id: Int,
    val records: List<Int>,
)
