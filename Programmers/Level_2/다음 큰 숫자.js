function solution(n) {
  const nOne = n.toString(2).split('').filter(b => b === '1').length;

  for (let i = n + 1; i <= 1000000; i++) {
    const iOne = i.toString(2).split('').filter(b => b === '1').length;

    if (nOne === iOne) {
      return i;
    }
  }
}
