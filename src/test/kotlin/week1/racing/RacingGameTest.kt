package week1.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.random.nextInt

class RacingGameTest {
    @Test
    fun `{given} 자동차 대수 0대 시도 횟수 0번 {when} start() {then} gameRounds 는 Empty 상태`() {
        val game = RacingGame(0, 0)
        game.start()
        assertThat(game.gameRounds.isEmpty()).isTrue()
    }

    @Test
    fun `{given} 자동차 1대 이상 시도 횟수 1회 이상 {when} start() {then} records size == 자동차 대수, gameRounds size == 시도횟수`() {
        val numCar = Random.nextInt(1..10)
        val numTries = Random.nextInt(1..10)
        val game = RacingGame(numCar, numTries)
        game.start()
        assertThat(game.gameRounds.size).isEqualTo(numTries)
        assertThat(game.gameRounds[0].records.size).isEqualTo(numCar)
    }
}
