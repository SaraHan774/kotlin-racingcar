package week1.step3.view

class InputView {
    fun readIntSafelyOrZero(promptMessage: String): Int {
        if (promptMessage.isNotBlank()) println(promptMessage)
        return readlnOrNull()?.toIntOrNull() ?: 0
    }

    companion object {
        const val HOW_MANY_CARS_MESSAGE = "자동차 대수는 몇 대 인가요?"
        const val HOW_MANY_TRIES_MESSAGE = "시도할 횟수는 몇 회 인가요?"
    }
}
