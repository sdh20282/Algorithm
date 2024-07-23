function solution(sequence) {
  const dp = [];
  let max = 0;

  dp[0] = [sequence[0], -sequence[0]];
  max = Math.max(dp[0][0], dp[0][1], max);

  for (let i = 1; i < sequence.length; i++) {
    dp[i] = [Math.max(sequence[i], sequence[i] + dp[i - 1][1]), Math.max(-sequence[i], -sequence[i] + dp[i - 1][0])];
    max = Math.max(dp[i][0], dp[i][1], max);
  }

  return max;
}
