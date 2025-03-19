const gcd = (a, b) => {
  if (a % b === 0) {
    return b;
  }

  return gcd(b, a % b);
}

const lcm = (a, b) => {
  return a * b / gcd(a, b);
}

function solution(arr) {
  let index = 0;

  while (true) {
    if (index === arr.length - 1) {
      break;
    }

    const a = arr[index++];
    const b = arr[index];

    arr[index] = lcm(a, b);
  }

  return arr[index];
}
