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
    const numbers = input[1].split(' ').map(e => parseInt(e));
    const dp = new Array(n).fill(0);

    dp[0] = numbers[0];

    for (let index = 1; index < n; index++) {
      dp[index] = Math.max(dp[index - 1] + numbers[index], numbers[index]);
    }

    console.log(dp.reduce((acc, cur) => {
      if (cur >= acc) {
        acc = cur;
      }

      return acc;
    }, -1000));

    process.exit();
  });

