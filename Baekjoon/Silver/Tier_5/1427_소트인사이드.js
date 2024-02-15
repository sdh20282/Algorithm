const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = '';

readline
  .on('line', (line) => {
    input = line;
  })
  .on('close', () => {
    console.log(input.split("").sort((a, b) => b - a).join(""));

    process.exit();
  });


