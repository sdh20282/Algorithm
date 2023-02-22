function solution(n, s) {
    if (s < n) {
        return [-1]
    }

    const answer = new Array(n).fill(parseInt(s / n));
    s = s % n;

    for (let i = 0; i < s; i++) {
        answer[i] += 1
    }

    return answer.sort()
}
