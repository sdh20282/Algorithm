const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

readline
  .on('line', (line) => {
    input.push(parseInt(line));
  })
  .on('close', () => {
    const [N, ...stairs] = input;
    const dp = new Array(N).fill(0);

    dp[0] = stairs[0]
    dp[1] = stairs[0] + stairs[1];
    dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

    for (let i = 3; i < N; i++) {
      dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i];
    }

    console.log(dp[N - 1]);
    
    process.exit();
});
