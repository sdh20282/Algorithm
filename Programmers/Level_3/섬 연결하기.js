// function solution(n, costs) {
//     const visited = Array(n).fill(0);
//     let sum = 0, index = 1;
//     costs.sort((a, b) => a[2] - b[2]);

//     for (let t = 0; t < costs.length; t++) {
//         const now_left = costs[index - 1][0], now_right = costs[index - 1][1];
//         const now_left_val = visited[now_left], now_right_val = visited[now_right];

//         if (now_left_val == now_right_val && now_left_val != 0) {
//             index++;
//             continue;
//         }

//         if (now_left_val != 0) {
//             for (let i = 0; i < n; i++) {
//                 if (visited[i] == now_left_val) {
//                     visited[i] = index;
//                 }
//             }
//         }

//         if (now_right_val != 0) {
//             for (let i = 0; i < n; i++) {
//                 if (visited[i] == now_right_val) {
//                     visited[i] = index;
//                 }
//             }
//         }

//         visited[now_left] = index;
//         visited[now_right] = index;
//         sum += costs[index - 1][2];
//         index++;
//     }

//     return sum;
// }

function solution(n, costs) {
    const union = Array(n).fill(-1);
    let sum = 0;
    costs.sort((a, b) => a[2] - b[2]);

    for (const cost of costs) {
        const nodes = [cost[0], cost[1]];

        for (let i = 0; i < 2; i++) {
            while (union[nodes[i]] != -1) {
                nodes[i] = union[nodes[i]];
            }
        }

        if (nodes[0] === nodes[1]) {
            continue;
        }

        union[nodes[1]] = cost[0];
        sum += cost[2];
    }

    return sum;
}
