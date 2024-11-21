package week1.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarTest {
    // 전진하는 경우
    @Test
    fun `{given} RacingCar currenPosition = 1 {when} moveForward(true) {then} currenPosition == 2`() {
        val racingCar = RacingCar()
        assertThat(racingCar.currentPosition).isEqualTo(1)
        racingCar.moveForward(shouldMove = true)
        assertThat(racingCar.currentPosition).isEqualTo(2)
    }

    // 전진하지 않는 경우
    @Test
    fun `{given} RacingCar currenPosition = 1 {when} moveForward(false) currenPosition == 1`() {
        val racingCar = RacingCar()
        assertThat(racingCar.currentPosition).isEqualTo(1)
        racingCar.moveForward(shouldMove = false)
        assertThat(racingCar.currentPosition).isEqualTo(1)
    }
}
