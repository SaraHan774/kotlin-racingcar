package week1.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import week1.step3.RacingCar

class RacingCarTest {

    @Test
    fun `{given} RacingCar currenPosition = 1 {when} moveForward() 1회 호출 {then} currenPosition == 2`() {
        val racingCar = RacingCar()
        assertThat(racingCar.currentPosition).isEqualTo(1)
        racingCar.moveForward()
        assertThat(racingCar.currentPosition).isEqualTo(2)
    }
}