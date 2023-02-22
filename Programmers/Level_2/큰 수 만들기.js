function solution(number, k) {
    let answer = [];

    for (const now of number) {
        while (k > 0 && answer[answer.length - 1] < now && answer.length > 0) {
            answer.pop();
            k--;
        }

        answer.push(now);
    }

    return answer.slice(0, number.length - k).join("");
}
