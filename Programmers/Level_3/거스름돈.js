function solution(n, money) {
  const dp = new Array(n + 1).fill(0);

  dp[0] = 1;

  for (const coin of money) {
    for (let target = coin; target < n + 1; target++) {
      dp[target] = (dp[target] + dp[target - coin]) % 1000000007;
    }
  }

  return dp[n] % 1000000007;
}
