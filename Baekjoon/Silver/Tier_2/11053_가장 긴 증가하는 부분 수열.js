const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

readline
  .on('line', (line) => {
    input.push(line.split(" ").map(Number));
  })
  .on('close', () => {
    const [N, numbers] = input;
    const dp = new Array(N).fill(0);

    for (let i = 0; i < N; i++) {
      let max = 0;

      for (let j = 0; j < i; j++) {
        if (numbers[i] > numbers[j] && dp[j] > max) {
          max = dp[j];
        }
      }

      dp[i] = max + 1;
    }

    console.log(Math.max(...dp));

    process.exit();
  });
