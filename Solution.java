
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public String reverseParentheses(String s) {
        char[] input = s.toCharArray();
        Deque<Integer> indexOpeningParentheses = new ArrayDeque<>();

        for (int i = 0; i < input.length; ++i) {
            if (input[i] == '(') {
                indexOpeningParentheses.push(i);
                continue;
            }
            if (input[i] == ')') {
                int start = indexOpeningParentheses.pop() + 1;
                int end = i - 1;
                reverse(start, end, input);
            }
        }

        return createReverseParentheses(input);
    }

    private String createReverseParentheses(char[] input) {
        StringBuilder reverseParentheses = new StringBuilder();
        for (char current : input) {
            if (current != '(' && current != ')') {
                reverseParentheses.append(current);
            }
        }
        return reverseParentheses.toString();
    }

    private void reverse(int start, int end, char[] input) {
        while (start <= end) {
            swap(start, end, input);
            ++start;
            --end;
        }
    }

    private void swap(int first, int second, char[] input) {
        char temp = input[first];
        input[first] = input[second];
        input[second] = temp;
    }
}
