
using System;
using System.Collections.Generic;

public class Solution
{
    public string ReverseParentheses(string s)
    {
        char[] input = s.ToCharArray();
        Stack<int> indexOpeningParentheses = new Stack<int>();

        for (int i = 0; i < input.Length; ++i)
        {
            if (input[i] == '(')
            {
                indexOpeningParentheses.Push(i);
                continue;
            }
            if (input[i] == ')')
            {
                int start = indexOpeningParentheses.Pop() + 1;
                int end = i - 1;
                Reverse(start, end, input);
            }
        }

        return CreateReverseParentheses(input);
    }

    private String CreateReverseParentheses(char[] input)
    {
        StringBuilder reverseParentheses = new StringBuilder();
        foreach (char current in input)
        {
            if (current != '(' && current != ')')
            {
                reverseParentheses.Append(current);
            }
        }
        return reverseParentheses.ToString();
    }

    private void Reverse(int start, int end, char[] input)
    {
        while (start <= end)
        {
            Swap(start, end, input);
            ++start;
            --end;
        }
    }

    private void Swap(int first, int second, char[] input)
    {
        char temp = input[first];
        input[first] = input[second];
        input[second] = temp;
    }
}
