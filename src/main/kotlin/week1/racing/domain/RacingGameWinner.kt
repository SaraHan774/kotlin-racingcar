package week1.racing.domain

class RacingGameWinner {
    fun getWinners(gameRoundRecord: List<GameRoundRecord>): List<GameRoundRecord> {
        val maxDistance = gameRoundRecord.maxOf { it.distance }
        return gameRoundRecord.filter { it.distance == maxDistance }
    }
}
