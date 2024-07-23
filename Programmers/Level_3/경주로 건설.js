function solution(board) {
  const dr = [1, 0, -1, 0];
  const dc = [0, 1, 0, -1];
  const N = board.length;

  const canMove = (r, c) => {
    if (r >= 0 && r < N && c >= 0 && c < N && !board[r][c]) {
      return true;
    }

    return false;
  }

  let answer = Infinity;
  const costs = new Array(N).fill(0).map(_ => new Array(N).fill(Infinity));
  const q = [];
  let qIdx = 0;

  costs[0][0] = 0;

  if (!board[0][1]) {
    costs[0][1] = 100;
    q.push([0, 1, 100, 1]);
  }

  if (!board[1][0]) {
    costs[1][0] = 100;
    q.push([1, 0, 100, 0]);
  }

  while (qIdx < q.length) {
    const [r, c, cnt, dir] = q[qIdx];

    if (r === N - 1 && c === N - 1) {
      answer = Math.min(answer, cnt);
      qIdx += 1;

      continue;
    }

    for (let d = 0; d < 4; d++) {
      const [nr, nc] = [r + dr[d], c + dc[d]];
      const ncnt = cnt + (dir === d ? 100 : 600);

      if (!canMove(nr, nc) || ncnt >= costs[nr][nc] + 500) {
        continue;
      }

      costs[nr][nc] = ncnt;
      q.push([nr, nc, ncnt, d]);
    }

    qIdx += 1;
  }

  return answer;
}
