const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

readline
  .on('line', (line) => {
    input.push(line);
  })
  .on('close', () => {
    const [R, C] = input[0].split(" ").map(Number);
    const board = new Array(R);

    for (let index = 0; index < R; index++) {
      board[index] = input[index + 1].split("");
    }

    const visited = new Array(26).fill(false);
    const dr = [-1, 1, 0, 0];
    const dc = [0, 0, -1, 1];
    let answer = 0;

    const DFS = (r, c, count) => {
      answer = Math.max(answer, count);

      for (let d = 0; d < 4; d++) {
        const nr = r + dr[d];
        const nc = c + dc[d];

        if (nr >= 0 && nc >= 0 && nr < R && nc < C && !visited[board[nr][nc].charCodeAt() - 65]) {
          visited[board[nr][nc].charCodeAt() - 65] = true;
          DFS(nr, nc, count + 1);
          visited[board[nr][nc].charCodeAt() - 65] = false;
        }
      }
    }

    visited[board[0][0].charCodeAt() - 65] = true;
    DFS(0, 0, 1);

    console.log(answer);

    process.exit();
  });

