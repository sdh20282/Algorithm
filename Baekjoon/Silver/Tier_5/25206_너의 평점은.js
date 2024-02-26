const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

const table = {
  "A+": 4.5,
  "A0": 4.0,
  "B+": 3.5,
  "B0": 3.0,
  "C+": 2.5,
  "C0": 2.0,
  "D+": 1.5,
  "D0": 1.0,
  "F": 0.0
}

readline
  .on('line', (line) => {
    input.push(line.split(' '));
  })
  .on('close', () => {
    let score = 0;
    let total = 0;

    for (const [a, b, c] of input) {
      if (c === "P") {
        continue;
      }

      total += b * table[c];
      score += +b;
    }

    console.log(total / score);
    process.exit();
  });

