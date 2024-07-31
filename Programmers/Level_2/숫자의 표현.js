function solution(n) {
  let count = 1;

  const check = (target) => {
    let step = 0;

    while (step < n) {
      step += target;
      target += 1;
    }

    return n === step ? true : false;
  }

  for (let i = 1; i <= n / 2; i++) {
    if (check(i)) {
      count += 1;
    }
  }

  return count;
}
