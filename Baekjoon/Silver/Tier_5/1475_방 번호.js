const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = "";

readline
  .on('line', (line) => {
    input = line;
  })
  .on('close', () => {
    const numbers = new Array(10).fill(0);

    for (let i = 0; i < input.length; i++) {
      numbers[parseInt(input[i])] += 1;
    }

    numbers[6] += numbers[9];
    numbers[6] = parseInt(numbers[6] / 2) + numbers[6] % 2;
    numbers[9] = 0;

    console.log(Math.max(...numbers));

    process.exit();
  });

