function solution(sequence, k) {
  let answer = [0, sequence.length];
  let s = e = 0;
  let total = sequence[0];

  while (e < sequence.length - 1) {
    if (total < k) {
      e += 1;
      total += sequence[e];
    }

    if (total > k) {
      total -= sequence[s];
      s += 1;
    }

    if (total === k) {
      if (answer[1] - answer[0] + 1 > e - s + 1) {
        answer = [s, e];
      }

      e += 1;
      total += sequence[e];
    }
  }

  while (s < sequence.length - 1) {
    total -= sequence[s];
    s += 1;

    if (total === k) {
      if (answer[1] - answer[0] + 1 > e - s + 1) {
        answer = [s, e];
      }
    }
  }

  return answer;
}
