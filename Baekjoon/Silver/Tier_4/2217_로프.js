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
    const [N, ...ropes] = input;

    ropes.sort((a, b) => b - a);

    const answer = [];

    for (let i = 0; i < N; i++) {
      answer.push(ropes[i] * (i + 1));
    }

    console.log(Math.max(...answer));

    process.exit();
  });

