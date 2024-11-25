package week1.racing.view

class InputView {
    fun readCarNames(promptMessage: String): List<String> {
        if (promptMessage.isNotBlank()) println(promptMessage)
        val input = readlnOrNull()
        return input?.let(::parseCarNames) ?: emptyList()
    }

    private fun parseCarNames(input: String): List<String> {
        return input.split(",")
    }

    fun readIntSafelyOrZero(promptMessage: String): Int {
        if (promptMessage.isNotBlank()) println(promptMessage)
        return readlnOrNull()?.toIntOrNull() ?: 0
    }

    companion object {
        const val ENTER_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val HOW_MANY_ROUNDS_MESSAGE = "시도할 횟수는 몇 회 인가요?"
    }
}
