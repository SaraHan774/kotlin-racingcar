package week1.step2

import java.util.LinkedList

class Calculator {
    private val minInputTokens = 3

    fun calculate(input: String?): String {
        val queue = parseInput(input)
        while (queue.size > 1) {
            val x = queue.poll()
            val op = queue.poll()
            val y = queue.poll()
            val result = Operator.from(op).applyTo(Operands(x, y)).toString()
            queue.addFirst(result)
        }
        return queue.poll()
    }

    private fun parseInput(input: String?): LinkedList<String> {
        require(input.isNullOrBlank().not()) {
            "Illegal argument $input. Input cannot be null or empty!"
        }

        return input!!.split(" ")
            .takeIf { it.size >= minInputTokens }
            ?.toCollection(LinkedList())
            ?: throw IllegalStateException("At least 2 operands and 1 operator is required.")
    }

    enum class Operator(private val symbol: String, val applyTo: (Operands) -> Int) {
        Plus("+", { it.x + it.y }),
        Minus("-", { it.x - it.y }),
        Divide("/", { it.x / it.y }),
        Multiply("*", { it.x * it.y }),;

        companion object {
            fun from(input: String): Operator {
                return entries.find { it.symbol == input } ?: throw IllegalArgumentException("Invalid Operator $input")
            }
        }
    }

    data class Operands(
        private val _x: String,
        private val _y: String,
    ) {
        val x: Int = getIntOrThrow(_x)
        val y: Int = getIntOrThrow(_y)

        private fun getIntOrThrow(n: String): Int {
            require(n.isNotEmpty() || n.isNotBlank()) {
                "Invalid operand format $n"
            }
            return n.toInt()
        }
    }
}
