function solution(n, build_frame) {
  const map = new Array(n + 1).fill(0).map(_ => new Array(n + 1).fill(0).map(_ => []));

  const checkPosition = (x, y) => {
    if (x >= 0 && x <= n && y >= 0 && y <= n) {
      return true;
    }

    return false;
  }

  const check = (x, y, target) => {
    return checkPosition(x, y) && map[x][y].includes(target);
  }

  const canBuildPillar = (x, y) => {
    if (y === 0) {
      return true;
    }

    if (check(x - 1, y, 1) || check(x, y, 1)) {
      return true;
    }

    if (check(x, y - 1, 0)) {
      return true;
    }

    return false;
  }

  const canDeletePillar = (x, y) => {
    if (check(x, y + 1, 0) && (!check(x - 1, y + 1, 1) && !check(x, y + 1, 1))) {
      return false;
    }

    if ((check(x, y + 1, 1) && (!check(x + 1, y, 0) && ((!check(x - 1, y + 1, 1) && check(x + 1, y + 1, 1)) || (check(x - 1, y + 1, 1) && !check(x + 1, y + 1, 1)) || (!check(x - 1, y + 1, 1) && !check(x + 1, y + 1, 1)))))) {
      return false;
    }

    if ((check(x - 1, y + 1, 1) && (!check(x - 1, y, 0) && ((!check(x - 2, y + 1, 1) && check(x, y + 1, 1)) || (check(x - 2, y + 1, 1) && !check(x, y + 1, 1)) || (!check(x - 2, y + 1, 1) && !check(x, y + 1, 1)))))) {
      return false;
    }

    return true;
  }

  const canBuildBoard = (x, y) => {
    if (check(x, y - 1, 0) || check(x + 1, y - 1, 0)) {
      return true;
    }

    if (check(x - 1, y, 1) && check(x + 1, y, 1)) {
      return true;
    }

    return false;
  }

  const canDeleteBoard = (x, y) => {
    if ((check(x, y, 0) && !check(x - 1, y, 1) && !check(x, y - 1, 0)) || (check(x + 1, y, 0) && !check(x + 1, y, 1) && !check(x + 1, y - 1, 0))) {
      return false;
    }

    if ((check(x - 1, y, 1) && !check(x, y - 1, 0) && !check(x - 1, y - 1, 0)) || check(x + 1, y, 1) && !check(x + 1, y - 1, 0) && !check(x + 2, y - 1, 0)) {
      return false;
    }

    return true;
  }

  for (const frame of build_frame) {
    const [x, y, structure, command] = frame;

    if (structure === 0) {
      if (command === 1 && canBuildPillar(x, y)) {
        map[x][y].push(0);
      }

      if (command === 0 && canDeletePillar(x, y)) {
        const targetIndex = map[x][y].indexOf(0);

        if (targetIndex === -1) {
          continue;
        }

        map[x][y].splice(targetIndex, 1);
      }
    }

    if (structure === 1) {
      if (command === 1 && canBuildBoard(x, y)) {
        map[x][y].push(1);
      }

      if (command === 0 && canDeleteBoard(x, y)) {
        const targetIndex = map[x][y].indexOf(1);

        if (targetIndex === -1) {
          continue;
        }

        map[x][y].splice(targetIndex, 1);
      }
    }
  }

  const answer = [];

  for (let i = 0; i <= n; i++) {
    for (let j = 0; j <= n; j++) {
      if (map[i][j].length === 0) {
        continue;
      }

      if (map[i][j].includes(0)) {
        answer.push([i, j, 0]);
      }

      if (map[i][j].includes(1)) {
        answer.push([i, j, 1]);
      }
    }
  }

  return answer;
}
