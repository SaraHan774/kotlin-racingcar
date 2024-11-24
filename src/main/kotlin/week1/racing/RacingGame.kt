package week1.racing

class RacingGame(
    carNames: List<String>,
    private val numRounds: Int,
    private val carMovementDecider: MovementDecider = CarMovementDecider()
) {
    private val cars = carNames.map { name -> RacingCar(name, carMovementDecider) }
    private val _gameRounds = mutableListOf<GameRound>()
    val gameRounds: List<GameRound> = _gameRounds

    init {
        require(cars.isNotEmpty() && numRounds > 0) {
            "Game cannot be started! (cars.size = ${cars.size}, numRounds = $numRounds)"
        }
    }

    fun start() {
        repeat(numRounds) { round ->
            startRound(round)
        }
    }

    private fun startRound(round: Int) {
        val list = mutableListOf<Record>()
        cars.forEach { car ->
            car.moveForward()
            list.add(Record(car.name, car.currentPosition))
        }
        _gameRounds.add(GameRound(id = round + 1, records = list))
    }
}

fun List<GameRound>.getWinnerNames(): List<String> {
    check(this.isNotEmpty())
    val lastRecord = this.last().records
    val maxRecord = lastRecord.max()
    val winnerNames = lastRecord.filter { it.distance == maxRecord.distance }.map { it.name }
    return winnerNames
}

data class GameRound(
    val id: Int,
    val records: List<Record>,
)

data class Record(
    val name: String,
    val distance: Int,
) : Comparable<Record> {
    override fun compareTo(other: Record): Int {
        return this.distance.compareTo(other.distance)
    }
}
