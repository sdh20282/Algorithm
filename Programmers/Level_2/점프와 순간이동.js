function solution(n) {
  let count = 1;

  while (n !== 1) {
    const rest = n % 2;

    if (rest === 1) {
      n -= 1;
      count += 1;
    } else {
      n /= 2;
    }
  }

  return count;
}
