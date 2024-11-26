package week1.racing.domain

class WinnerRecord(private val game: RacingGame) {
    fun getFinalWinnerNames(): List<String> {
        return game.getMaxDistanceRecords(game.gameRounds.last().records).map { it.name }
    }
}