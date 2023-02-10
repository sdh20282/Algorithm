function solution(routes) {
    routes.sort((a, b) => a[0] - b[0]);

    let answer = 1, now = routes[0][1];

    for (let index = 1; index < routes.length; index++) {
        if (now < routes[index][0]) {
            answer += 1;
            now = routes[index][1];
        }

        if (now > routes[index][1]) {
            now = routes[index][1];
        }
    }

    return answer;
}
