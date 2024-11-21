package week1.calculator

import java.util.LinkedList

class Calculator {
    fun calculate(input: String?): String {
        val queue = parseInput(input)
        while (queue.size > 1) {
            val x = queue.poll()
            val op = queue.poll()
            val y = queue.poll()
            val result = Operator.from(op).apply(x.toInt(), y.toInt()).toString()
            queue.addFirst(result)
        }
        return queue.poll()
    }

    private fun parseInput(input: String?): LinkedList<String> {
        require(input.isNullOrBlank().not()) {
            "Illegal argument $input. Input cannot be null or empty!"
        }

        return input!!.split(" ")
            .takeIf { it.size >= MIN_INPUT_TOKENS }
            ?.toCollection(LinkedList())
            ?: throw IllegalStateException("At least 2 operands and 1 operator is required.")
    }

    companion object {
        private const val MIN_INPUT_TOKENS = 3
    }
}
