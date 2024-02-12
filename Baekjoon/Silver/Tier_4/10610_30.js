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
    const numbers = input.split("").map(Number).sort((a, b) => b - a);
    const sum = numbers.reduce((acc, cur) => acc + cur, 0);

    console.log(sum % 3 === 0 && numbers.includes(0) ? numbers.join("") : -1);

    process.exit();
  });

