package week1.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingGameTest {
    // 초기화 검증 - 자동차 or 시도 횟수 0 인 경우
    @Test
    fun `{given} numCar = 0, numRounds = 0 {when} start() {then} gameRounds isEmpty`() {
        val game = RacingGame(numCars = 0, numRounds = 0)
        assertThrows<IllegalArgumentException> { game.start() }
    }

    @Test
    fun `{given} numCar = 0, numRounds = 5 {when} start() {then} gameRounds isEmpty`() {
        val game = RacingGame(numCars = 0, numRounds = 5)
        assertThrows<IllegalArgumentException> { game.start() }
    }

    @Test
    fun `{given} numCars = 5, numRounds = 0 {when} start() {then} gameRounds isEmpty`() {
        val game = RacingGame(numCars = 5, numRounds = 0)
        assertThrows<IllegalArgumentException> { game.start() }
    }

    @Test
    fun `{given} numCars = 3, numRounds = 5 {when} start() {then} records size == 3, gameRounds size == 5`() {
        val numCar = 3
        val numRounds = 5
        val game = RacingGame(numCar, numRounds)

        game.start()

        assertEquals(numCar, game.gameRounds[0].records.size)
        assertEquals(numRounds, game.gameRounds.size)
    }

    // record 검증
    @Test
    fun `{given} numCars = 2, numRounds = 1 {when} start() {then} gameRound id = 1, records size == 2`() {
        val numCars = 2
        val numRounds = 1
        val racingGame = RacingGame(numCars, numRounds)

        racingGame.start()

        val gameRound = racingGame.gameRounds.first()
        assertEquals(1, gameRound.id)
        assertEquals(numCars, gameRound.records.size)
    }
}
