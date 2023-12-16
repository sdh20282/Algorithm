const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

function* zip(n, a, b) {
  for (let i = 0; i < n; i++) yield [a[i], b[i]]
}

readline
  .on('line', (line) => {
    input.push(line.split(' ').map((el) => parseInt(el)));
  })
  .on('close', () => {
    const A = input[1].sort((a, b) => a - b);
    const B = input[2].sort((a, b) => a - b).reverse();

    console.log([...zip(input[0][0], A, B)].reduce((acc, cur) => {
      return acc + cur[0] * cur[1];
    }, 0));

    process.exit();
  });
