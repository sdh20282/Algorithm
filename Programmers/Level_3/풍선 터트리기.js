function solution(a) {
  let minValue = Infinity;

  for (const i of a) {
    if (i < minValue) {
      minValue = i;
    }
  }

  let count = 0;
  let nowMin = Infinity;

  for (let i = 0; i < a.length; i++) {
    if (a[i] === minValue) {
      break;
    }

    if (a[i] < nowMin) {
      count += 1;
      nowMin = a[i];
    }
  }

  nowMin = Infinity;

  for (let i = a.length - 1; i >= 0; i--) {
    if (a[i] === minValue) {
      break;
    }

    if (a[i] < nowMin) {
      count += 1;
      nowMin = a[i];
    }
  }

  return count + 1;
}
