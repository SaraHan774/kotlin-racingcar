package week1

import java.util.Stack


fun main() {
    // get input from console
    val input = readln()
    Calculator().calculate(input)
}

// TODO -  테스트 코드 작성하기
class Calculator {

    fun calculate(input: String?) {
        require(input.isNullOrEmpty().not()) {
            "Illegal argument $input. Input cannot be null or empty!"
        }

        val stack = Stack<String>()
        input!!.split(" ", "\t", "\\s")
            .takeIf { it.size >= 3 }
            ?.reversed()
            ?.forEach { stack.push(it) }
            ?: throw IllegalStateException("At least 2 operands and 1 operator is required.")

        while (stack.size > 1) {
            val x = stack.pop()
            val operator = Operator.fromInput(stack.pop())
            val y = stack.pop()

            val operands = Operands(x, y)
            val result = operands.applyOperator(operator).toString()
            stack.push(result)
        }
        println(stack.pop())
    }

    enum class Operator(private val symbol: String) {
        Plus("+"), Minus("-"), Divide("/"), Multiply("*");

        companion object {
            fun fromInput(input: String): Operator {
                return entries.find { it.symbol == input } ?: throw IllegalArgumentException("Invalid Operator $input")
            }
        }
    }

    data class Operands(
        private val _x: String,
        private val _y: String
    ) {
        val x: Int = getOperandOrThrow(_x)
        val y: Int = getOperandOrThrow(_y)

        private fun getOperandOrThrow(n: String): Int {
            require(n.isNotEmpty() && n.matches(Regex("^\\d+\$"))) {
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
