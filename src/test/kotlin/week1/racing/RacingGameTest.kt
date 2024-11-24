package week1.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingGameTest {
    // 초기화 검증 - 자동차 or 시도 횟수 0 인 경우
    @Test
    fun `{given} carNames = emptyList(), numRounds = 0 {when} start() {then} gameRounds isEmpty`() {
        val game = RacingGame(carNames = emptyList(), numRounds = 0)
        assertThrows<IllegalArgumentException> { game.start() }
    }

    @Test
    fun `{given} carNames = emptyList(), numRounds = 5 {when} start() {then} gameRounds isEmpty`() {
        val game = RacingGame(carNames = emptyList(), numRounds = 5)
        assertThrows<IllegalArgumentException> { game.start() }
    }

    @Test
    fun `{given} carNames = list, numRounds = 0 {when} start() {then} gameRounds isEmpty`() {
        val game = RacingGame(carNames = listOf("A", "B", "C", "D", "E"), numRounds = 0)
        assertThrows<IllegalArgumentException> { game.start() }
    }

    @Test
    fun `{given} carNames = list, numRounds = 5 {when} start() {then} records size == 3, gameRounds size == 5`() {
        val carNames = listOf("A", "B", "C")
        val numRounds = 5
        val game = RacingGame(carNames, numRounds)

        game.start()

        assertEquals(carNames.size, game.gameRounds[0].records.size)
        assertEquals(numRounds, game.gameRounds.size)
    }

    // record 검증
    @Test
    fun `{given} carNames = list, numRounds = 1 {when} start() {then} gameRound id = 1, records size == 2`() {
        val carNames = listOf("A", "B")
        val numRounds = 1
        val racingGame = RacingGame(carNames, numRounds)

        racingGame.start()

        val gameRound = racingGame.gameRounds.first()
        assertEquals(1, gameRound.id)
        assertEquals(carNames.size, gameRound.records.size)
    }
}
