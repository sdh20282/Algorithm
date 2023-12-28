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
    const [N, ...words] = input;
    let result = 0;

    check: for (const word of words) {
      const letter = [];
      let prev = "";

      for (const char of word) {
        if (!letter.includes(char)) {
          letter.push(char);
          prev = char;
        } else {
          if (prev === char) {
            continue;
          }

          continue check;
        }
      }

      result += 1;
    }

    console.log(result);
  });

