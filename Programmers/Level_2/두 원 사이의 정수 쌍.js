function solution(r1, r2) {
  let count = 0;

  for (let i = 1; i <= r2; i++) {
    const large = Math.floor(Math.sqrt(r2 * r2 - i * i));
    let small = 0;

    if (i <= r1) {
      small = Math.ceil(Math.sqrt(r1 * r1 - i * i));
    }

    count += (large - small + 1);
  }

  return count * 4;
}
