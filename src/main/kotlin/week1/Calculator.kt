package week1

import java.util.LinkedList

class Calculator {

    fun calculate(input: String?): String {
        require(input.isNullOrBlank().not()) {
            "Illegal argument $input. Input cannot be null or empty!"
        }

        val queue = input!!.split(" ")
            .takeIf { it.size >= 3 }
            ?.toCollection(LinkedList())
            ?: throw IllegalStateException("At least 2 operands and 1 operator is required.")

        while (queue.size > 1) {
            val x = queue.poll()
            val op = queue.poll()
            val y = queue.poll()
            val result = Operands(x, y).applyOperator(Operator.from(op)).toString()
            queue.addFirst(result)
        }
        return queue.poll()
    }

    enum class Operator(private val symbol: String) {
        Plus("+"), Minus("-"), Divide("/"), Multiply("*");

        companion object {
            fun from(input: String): Operator {
                return entries.find { it.symbol == input } ?: throw IllegalArgumentException("Invalid Operator $input")
            }
        }
    }

    data class Operands(
        private val _x: String,
        private val _y: String
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

    private fun Operands.applyOperator(operator: Operator): Int {
        return when (operator) {
            Operator.Plus -> x + y

            Operator.Minus -> x - y

            Operator.Divide -> x / y

            Operator.Multiply -> x * y
        }
    }
}
