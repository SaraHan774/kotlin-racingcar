package week1.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarTest {
    @Test
    fun `{given} RacingCar currenPosition = 1 {when} moveForward() 1회 호출 {then} currenPosition == 2`() {
        val racingCar = RacingCar()
        assertThat(racingCar.currentPosition).isEqualTo(1)
        racingCar.moveForward(shouldMove = true)
        assertThat(racingCar.currentPosition).isEqualTo(2)
    }
}
