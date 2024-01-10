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
    const A = new Set(input[1].split(" ").map(el => parseInt(el)));
    const B = new Set(input[2].split(" ").map(el => parseInt(el)));
    const intersect = new Set([...A].filter(x => B.has(x)));

    console.log(A.size + B.size - intersect.size - intersect.size);

    process.exit();
  });

