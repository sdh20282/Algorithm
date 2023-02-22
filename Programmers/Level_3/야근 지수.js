function solution(n, works) {
    works.sort((a, b) => a - b);

    for (let i = 0; i < n; i++) {
        if (works[works.length - 1] == 0) {
            break;
        }

        works[works.length - 1] -= 1;

        for (let index = works.length - 1; index > 0; index--) {
            if (works[index - 1] <= works[index]) {
                break;
            }

            let temp = works[index];
            works[index] = works[index - 1];
            works[index - 1] = temp;
        }
    }

    return works.reduce((acc, val) => acc + val * val, 0);
}
