const dirs = ['d', 'l', 'r', 'u'];
const moves = {
  'd': [1, 0],
  'l': [0, -1],
  'r': [0, 1],
  'u': [-1, 0],
};

function solution(n, m, x, y, r, c, k) {
  const shortestPath = Math.abs(x - r) + Math.abs(y - c);

  if (k < shortestPath || (k - shortestPath) % 2 === 1) {
    return 'impossible';
  }

  const pathes = [];

  let curX = x;
  let curY = y;
  let leftK = k;

  while (leftK > 0) {
    for (let index = 0; index < dirs.length; index++) {
      const dir = dirs[index];
      const [moveX, moveY] = moves[dir];
      const [nextX, nextY] = [curX + moveX, curY + moveY];

      if (nextX > n || nextX <= 0 || nextY > m || nextY <= 0) {
        continue;
      }

      const nextShortestPath = Math.abs(nextX - r) + Math.abs(nextY - c);

      if (leftK - 1 >= nextShortestPath && (leftK - 1 - nextShortestPath) % 2 === 0) {
        [curX, curY, leftK] = [nextX, nextY, leftK - 1];
        pathes.push(dir);

        break;
      }
    }
  }

  return pathes.join('');
}
