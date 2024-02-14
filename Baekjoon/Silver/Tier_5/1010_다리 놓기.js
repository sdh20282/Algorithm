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
    const T = parseInt(input[0]);

    for (let i = 1; i <= T; i++) {
      const [N, M] = input[i].split(" ").map(Number);
      let result = BigInt(1);

      for (let m = M; m > M - N; m--) {
        result *= BigInt(m);
      }

      for (let n = 1; n <= N; n++) {
        result /= BigInt(n);
      }

      console.log(result + "");
    }

    process.exit();
  });

