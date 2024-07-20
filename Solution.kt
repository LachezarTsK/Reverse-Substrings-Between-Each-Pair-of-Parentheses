
import java.util.ArrayDeque

class Solution {
    fun reverseParentheses(s: String): String {
        val input = s.toCharArray()
        val indexOpeningParentheses = ArrayDeque<Int>()

        for (i in input.indices) {
            if (input[i] == '(') {
                indexOpeningParentheses.push(i)
                continue;
            }
            if (input[i] == ')') {
                val start = indexOpeningParentheses.pop() + 1
                val end = i - 1
                reverse(start, end, input)
            }
        }

        return createReverseParentheses(input)
    }

    private fun createReverseParentheses(input: CharArray): String {
        val reverseParentheses = StringBuilder()
        for (current in input) {
            if (current != '(' && current != ')') {
                reverseParentheses.append(current)
            }
        }
        return reverseParentheses.toString()
    }

    private fun reverse(start: Int, end: Int, input: CharArray) {
        var start = start
        var end = end
        while (start <= end) {
            swap(start, end, input)
            ++start
            --end
        }
    }

    private fun swap(first: Int, second: Int, input: CharArray) {
        val temp = input[first]
        input[first] = input[second]
        input[second] = temp
    }
}
