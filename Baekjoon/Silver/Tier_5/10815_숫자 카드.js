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
    const [N, cards, M, numbers] = input;
    const set = new Set();

    cards.split(' ').forEach((n) => set.add(n));

    const answer = numbers.split(' ').reduce((acc, cur) => {
      set.has(cur) ? acc.push(1) : acc.push(0)
      return acc
    }, []);

    console.log(answer.join(' '));

    process.exit();
  });


