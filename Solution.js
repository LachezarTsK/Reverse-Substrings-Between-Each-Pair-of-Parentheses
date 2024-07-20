
/**
 * @param {string} s
 * @return {string}
 */
var reverseParentheses = function (s) {
    const input = s.split('');
    const indexOpeningParentheses = new Array();

    for (let i = 0; i < input.length; ++i) {
        if (input[i] === '(') {
            indexOpeningParentheses.push(i);
            continue;
        }
        if (input[i] === ')') {
            const start = indexOpeningParentheses.pop() + 1;
            const end = i - 1;
            reverse(start, end, input);
        }
    }

    return createReverseParentheses(input);
};

/**
 * @param {string[]} input
 * @return {string}
 */
function createReverseParentheses(input) {
    const reverseParentheses = new Array();
    for (let current of input) {
        if (current !== '(' && current !== ')') {
            reverseParentheses.push(current);
        }
    }
    return reverseParentheses.join('');
}

/**
 * @param {number} start
 * @param {number} end
 * @param {string[]} input
 * @return {void}
 */
function reverse(start, end, input) {
    while (start <= end) {
        swap(start, end, input);
        ++start;
        --end;
    }
}

/**
 * @param {number} first
 * @param {number} second
 * @param {string[]} input
 * @return {void}
 */
function swap(first, second, input) {
    [input[first], input[second]] = [input[second], input[first]];
}
