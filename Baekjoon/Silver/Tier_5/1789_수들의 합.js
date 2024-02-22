const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = 0;

readline
  .on('line', (line) => {
    input = parseInt(line);
  })
  .on('close', () => {
    let sum = 0, count = 0;

    for (let i = 1; ; i++) {
      sum += i
      count++;

      if (sum > input) {
        count--;

        break;
      }
    }

    console.log(count);

    process.exit();
  });

