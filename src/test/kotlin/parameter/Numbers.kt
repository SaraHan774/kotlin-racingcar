package parameter

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class Numbers {
    companion object {
        fun isOdd(x: Int) = x % 2 != 0
    }
}

class Strings {
    companion object {
        fun isBlank(input: String?) : Boolean = input != null && input.trim().isEmpty()
        fun isNullOrEmpty(input: String?) : Boolean = input == null || input.trim().isEmpty()
    }
}

class NumbersTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 5, -3, 15, Int.MAX_VALUE])
    fun isOdd_ShouldReturnTrueForOddNumbers(number: Int) {
        assertTrue(Numbers.isOdd(number))
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun isBlank_ShouldReturnTrueForBlankString(input: String) {
        assertTrue(Strings.isBlank(input))
    }

    @ParameterizedTest
    @NullSource
    fun isBlank_ShouldReturnFalseForNullInputs(input: String?) {
        assertThat(Strings.isBlank(input)).isFalse()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun isNullOrEmpty_ShouldReturnTrue(input: String?) {
        assertThat(Strings.isNullOrEmpty(input)).isTrue()
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" ", "\t", "\n"])
    fun isNullOrEmpty_ShouldReturnTrueForAll(input: String?) {
        assertThat(Strings.isNullOrEmpty(input)).isTrue()
    }
}

