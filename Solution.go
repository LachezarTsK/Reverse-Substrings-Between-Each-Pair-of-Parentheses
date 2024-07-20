
package main

import (
    "fmt"
    "reflect"
    "strings"
)

func reverseParentheses(s string) string {
    input := []byte(s)
    indexOpeningParentheses := []int{}

    for i := range input {
        if input[i] == '(' {
            indexOpeningParentheses = append(indexOpeningParentheses, i)
            continue
        }
        if input[i] == ')' {
            lastIndex := len(indexOpeningParentheses) - 1
            start := indexOpeningParentheses[lastIndex] + 1
            end := i - 1
            indexOpeningParentheses = indexOpeningParentheses[:lastIndex]
            reverse(start, end, input)
        }
    }

    return createReverseParentheses(input)
}

func createReverseParentheses(input []byte) string {
    reverseParentheses := strings.Builder{}
    for _, current := range input {
        if current != '(' && current != ')' {
            reverseParentheses.WriteByte(current)
        }
    }
    return reverseParentheses.String()
}

func reverse(start int, end int, input []byte) {
    swap := reflect.Swapper(input)
    for start <= end {
        swap(start, end)
        start++
        end--
    }
}
