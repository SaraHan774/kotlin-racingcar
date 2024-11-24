package week1.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingGameTest {
    private val nonEmptyListOfCarNames = listOf("A", "B", "C")
    private val nonZeroNumberOfRounds = 5

    // 초기화 검증 - 자동차 or 시도 횟수 0 인 경우
    @Test
    fun `{given} carNames = emptyList() & nonZeroNumberOfRounds {when} start() {then} gameRounds isEmpty`() {
        assertThrows<IllegalArgumentException> {
            RacingGame(carNames = emptyList(), numRounds = nonZeroNumberOfRounds)
        }
    }

    @Test
    fun `{given} nonEmptyListOfCarNames & numRounds = 0 {when} start() {then} gameRounds isEmpty`() {
        assertThrows<IllegalArgumentException> {
            RacingGame(carNames = nonEmptyListOfCarNames, numRounds = 0)
        }
    }

    @Test
    fun `{given} nonEmptyListOfCarNames & nonZeroNumberOfRounds {when} start() {then} recordSize = 총 차 대수, roundSize = 총 라운드 개수`() {
        val game = RacingGame(nonEmptyListOfCarNames, nonZeroNumberOfRounds)

        game.start()

        assertEquals(nonEmptyListOfCarNames.size, game.gameRounds[0].records.size)
        assertEquals(nonZeroNumberOfRounds, game.gameRounds.size)
    }

    // record 검증
    @Test
    fun `{given} nonEmptyListOfCarNames & nonZeroNumberOfRounds {when} start() {then} gameRound id = 총 라운드 개수, records size == 총 차 대수`() {
        val racingGame = RacingGame(nonEmptyListOfCarNames, nonZeroNumberOfRounds)

        racingGame.start()

        val gameRound = racingGame.gameRounds.last()
        assertEquals(nonZeroNumberOfRounds, gameRound.id)
        assertEquals(nonEmptyListOfCarNames.size, gameRound.records.size)
    }

    // winner 선정 검증
    @Test
    fun `{given} nonEmptyListOfCarNames & nonZeroNumberOfRounds & 항상 모든 차가 전진할 경우 {when} start() {then} getMaxDistanceRecords() 사이즈 == 총 차 대수`() {
        val racingGame =
            RacingGame(nonEmptyListOfCarNames, nonZeroNumberOfRounds, carMovementDecider = { true }) // 항상 모든 차가 움직인다
        racingGame.start() // 게임 후에는 세 차가 모두 최장 길이 distance 레코드로 뽑혀야 한다
        assertEquals(racingGame.gameRounds.getMaxDistanceRecords().size, nonEmptyListOfCarNames.size)
    }

    @Test
    fun `{given} empty game rounds {when} getWinnerNames() {then} throws IllegalStateException`() {
        val records = listOf<GameRound>()
        assertThrows<IllegalStateException> { records.getMaxDistanceRecords() }
    }
}
