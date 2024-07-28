function solution(scores) {
  const wonho = scores[0];

  scores.sort((a, b) => a[0] === b[0] ? a[1] - b[1] : b[0] - a[0]);

  let answer = 1;
  let evaluation = 0;

  for (const score of scores) {
    if (wonho[0] < score[0] && wonho[1] < score[1]) {
      return -1;
    }

    if (score[1] < evaluation) {
      continue;
    }

    if (wonho[0] + wonho[1] < score[0] + score[1]) {
      answer++;
    }

    evaluation = score[1];
  }

  return answer;
}
