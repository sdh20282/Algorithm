function solution(n, results) {
  const history = new Array(n).fill(0).map(_ => new Array(n).fill(0));

  for (const result of results) {
    const [win, lose] = result;

    history[win - 1][lose - 1] = 1;
    history[lose - 1][win - 1] = -1;
  }

  for (let i = 0; i < n; i++) {
    const nowHistory = history[i];

    for (let k = 0; k < n; k++) {
      if (nowHistory[k] === 1) {
        for (let j = 0; j < n; j++) {
          if (k === j) {
            continue;
          }

          if (nowHistory[j] === -1) {
            history[k][j] = -1;
          }
        }
      }

      if (nowHistory[k] === -1) {
        for (let j = 0; j < n; j++) {
          if (k === j) {
            continue;
          }

          if (nowHistory[j] === 1) {
            history[k][j] = 1;
          }
        }
      }
    }
  }

  const canDetermineOrder = (idx) => {
    let zeroCount = 0;

    for (let i = 0; i < n; i++) {
      zeroCount += history[idx][i] === 0 ? 1 : 0;
    }

    return zeroCount === 1 ? true : false;
  }

  let answer = 0;

  for (let i = 0; i < n; i++) {
    if (!canDetermineOrder(i)) {
      continue;
    }

    answer += 1;
  }

  return answer;
}
