package week1.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import week1.racing.domain.MovementDecider
import week1.racing.domain.RacingGame
import week1.racing.domain.Record

class RacingGameTest {
    private val nonEmptyListOfCarNames = listOf("A", "B", "C")
    private val nonZeroNumberOfRounds = 5

    // 초기화 검증 - 자동차 or 시도 횟수 0 인 경우
    @Test
    fun `{given} carNames = emptyList() {when} start() {then} gameRounds isEmpty`() {
        assertThrows<IllegalArgumentException> { createRacingGame(carNames = emptyList()) }
    }

    @Test
    fun `{given} numRounds = 0 {when} start() {then} gameRounds isEmpty`() {
        assertThrows<IllegalArgumentException> { createRacingGame(numRounds = 0) }
    }

    @Test
    fun `{given} nonEmptyListOfCarNames & nonZeroNumberOfRounds {when} start() {then} recordSize = 총 차 대수, roundSize = 총 라운드 개수`() {
        val game = createRacingGame()

        game.start()

        assertEquals(nonEmptyListOfCarNames.size, game.gameRounds[0].records.size)
        assertEquals(nonZeroNumberOfRounds, game.gameRounds.size)
    }

    // record 검증
    @Test
    fun `{given} nonEmptyListOfCarNames & nonZeroNumberOfRounds {when} start() {then} gameRound id = 총 라운드 개수, records size == 총 차 대수`() {
        val racingGame = createRacingGame()

        racingGame.start()

        val gameRound = racingGame.gameRounds.last()
        assertEquals(nonZeroNumberOfRounds, gameRound.id)
        assertEquals(nonEmptyListOfCarNames.size, gameRound.records.size)
    }

    @Test
    fun `{given} Record 여러개 주어지고, 순차적으로 높은 distance 가질 때 {when} getMaxDistanceRecords() {then} 가장 마지막 Record 가 반환됨`() {
        val records = nonEmptyListOfCarNames.mapIndexed { index, name -> Record(name = name, distance = index) }
        val game = createRacingGame()

        val maxRecords = game.getMaxDistanceRecords(records)

        assertTrue(maxRecords.size == 1)
        assertTrue(maxRecords[0] == records.last())
    }

    private fun createRacingGame(
        carNames: List<String> = nonEmptyListOfCarNames,
        numRounds: Int = nonZeroNumberOfRounds,
        carMovementDecider: MovementDecider = MovementDecider { false },
    ) = RacingGame(
        carNames = carNames,
        numRounds = numRounds,
        carMovementDecider = carMovementDecider
    )
}
