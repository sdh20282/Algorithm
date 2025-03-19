function solution(k, tangerine) {
  const counts = {};
  const sizes = [];

  tangerine.forEach(t => {
    if (!counts[t]) {
      counts[t] = 0;
    }

    counts[t]++;
  });

  for (const size of Object.values(counts)) {
    sizes.push(size)
  }

  sizes.sort((a, b) => b - a);
  let curK = k;
  let count = 0;

  for (const size of sizes) {
    if (curK <= 0) {
      break;
    }

    curK -= size;
    count++;
  }

  return count;
}
