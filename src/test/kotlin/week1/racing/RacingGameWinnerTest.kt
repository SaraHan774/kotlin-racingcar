package week1.racing

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import week1.racing.domain.GameRoundRecord
import week1.racing.domain.RacingGameWinner

class RacingGameWinnerTest {
    @Test
    fun `{given} 움직인 거리가 3, 4, 5인 자동차 세 대 {when} getWinnersOf(GameRound) {then} 거리 5인 자동차가 우승`() {
        // given
        val racingGameWinner = RacingGameWinner()
        val winningRecord = GameRoundRecord(name = "C", distance = 5)
        val fakeGameRecords = listOf(
            GameRoundRecord(name = "A", distance = 3),
            GameRoundRecord(name = "B", distance = 4),
            GameRoundRecord(name = "C", distance = 5),
        )
        // when
        val winnerList = racingGameWinner.getWinners(fakeGameRecords)
        // then
        assertTrue(winnerList.size == 1)
        assertTrue(winnerList.contains(winningRecord))
    }
}
