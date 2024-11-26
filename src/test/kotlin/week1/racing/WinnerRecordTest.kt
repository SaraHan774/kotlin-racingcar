package week1.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import week1.racing.domain.RacingGame
import week1.racing.domain.WinnerRecord

class WinnerRecordTest {
    @Test
    fun `{given} 세 대의 자동차 매 라운드마다 각 자동차 모두 움직일때 {when} Game start() {then} 모두 우승자에 해당함`() {
        val carNames = listOf("A", "B", "C")
        val game = RacingGame(
            carNames = carNames,
            numRounds = 3,
            carMovementDecider = { true }
        )
        game.start()
        val winnerRecord = WinnerRecord(game)
        assertEquals(winnerRecord.getFinalWinnerNames(), carNames)
    }
}