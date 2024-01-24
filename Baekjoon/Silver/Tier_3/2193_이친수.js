const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

readline
  .on('line', (line) => {
    input.push(line);
  })
  .on('close', () => {
    const n = parseInt(input[0]);
    const dp = new Array(n).fill(0);

    dp[0] = dp[1] = 1;

    for (let index = 2; index < n; index++) {
      dp[index] = BigInt(dp[index - 1]) + BigInt(dp[index - 2]);
    }

    console.log(dp[n - 1].toString());

    process.exit();
  });

