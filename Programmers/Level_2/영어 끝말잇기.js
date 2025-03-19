function solution(n, words) {
  const check = {};
  let index = 0;
  let prev = "";
  let flag = true;

  for (index = 0; index < words.length; index++) {
    const cur = words[index];

    if (index !== 0 && (check[cur] || cur[0] !== prev[prev.length - 1])) {
      flag = false;

      break;
    }

    check[cur] = 1;
    prev = words[index];
  }

  if (flag) {
    return [0, 0]
  }

  return [index % n + 1, Math.floor(index / n) + 1];
}
