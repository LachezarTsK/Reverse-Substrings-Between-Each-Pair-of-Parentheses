
#include <deque>
#include <string>
#include <string_view>
using namespace std;

class Solution {

public:
    string reverseParentheses(string input) const {

        deque<int> indexOpeningParentheses;

        for (int i = 0; i < input.size(); ++i) {
            if (input[i] == '(') {
                indexOpeningParentheses.push_back(i);
                continue;
            }
            if (input[i] == ')') {
                int start = indexOpeningParentheses.back() + 1;
                indexOpeningParentheses.pop_back();
                int end = i - 1;
                reverse(start, end, input);
            }
        }

        return createReverseParentheses(input);
    }

    string createReverseParentheses(string_view input)const {
        string reverseParentheses;
        for (const auto& current : input) {
            if (current != '(' && current != ')') {
                reverseParentheses.push_back(current);
            }
        }
        return reverseParentheses;
    }

    void reverse(int start, int end, string& input) const {
        while (start <= end) {
            swap(input[start], input[end]);
            ++start;
            --end;
        }
    }
};
