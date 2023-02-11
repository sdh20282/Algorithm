function solution(n, t, m, p) {
    let answer = '', binary = '';;
    let num = 0;

    while (binary.length < t * m) {
        binary += num.toString(n).toUpperCase();
        num += 1;
    }

    for (let i = p - 1; i < t * m; i += m) {
        answer += binary[i];
    }

    return answer;
}
