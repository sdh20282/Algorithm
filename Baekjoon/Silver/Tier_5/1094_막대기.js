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
    let target = input;
    let cnt = 0;

    while (target > 0) {
      if (target & 1) {
        cnt++;
      }

      target >>= 1;
    }

    console.log(cnt)

    process.exit();
  });

