function solution(land) {
  const dr = [-1, 1, 0, 0];
  const dc = [0, 0, -1, 1];

  const n = land.length;
  const m = land[0].length;

  const sum = {};
  const visited = new Array(n).fill('').map(_ => new Array(m).fill(false));

  for (let j = 0; j < m; j++) {
    sum[j] = 0;
  }

  for (let j = 0; j < m; j++) {
    for (let i = 0; i < n; i++) {
      if (land[i][j] !== 1 || visited[i][j]) {
        continue;
      }

      const stack = [];
      let range = j;
      let count = 1;

      visited[i][j] = true;
      stack.push([i, j]);

      while (1) {
        if (stack.length === 0) {
          break;
        }

        const [r, c] = stack.pop();

        for (let i = 0; i < 4; i++) {
          const nr = r + dr[i];
          const nc = c + dc[i];

          if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && land[nr][nc] === 1)) {
            continue;
          }

          if (nc > range) {
            range = nc;
          }

          count += 1;
          visited[nr][nc] = true;

          stack.push([nr, nc]);
        }
      }

      for (let k = j; k <= range; k++) {
        sum[k] += count;
      }
    }
  }

  return Math.max(...Object.values(sum));
}
