function solution(A, B) {
    let answer = 0, index = 0;

    A.sort((a, b) => b - a);
    B.sort((a, b) => b - a);

    for (const a of A) {
        if (a < B[index]) {
            index += 1;
            answer += 1;
        }
    }

    return answer;
}
