function solution(n, tops) {
  const dp = new Array(n + 1);

  dp[0] = {
    endTriangle: 1,
    endRhombus: 0,
  }

  tops.forEach((top, idx) => {
    const now = {};

    if (top === 0) {
      now.endTriangle = (dp[idx].endTriangle * 2 + dp[idx].endRhombus) % 10007;
      now.endRhombus = (dp[idx].endTriangle + dp[idx].endRhombus) % 10007;
    } else {
      now.endTriangle = (dp[idx].endTriangle * 3 + dp[idx].endRhombus * 2) % 10007;
      now.endRhombus = (dp[idx].endTriangle + dp[idx].endRhombus) % 10007;
    }

    dp[idx + 1] = now;
  });

  return (dp[n].endTriangle + dp[n].endRhombus) % 10007;
}
