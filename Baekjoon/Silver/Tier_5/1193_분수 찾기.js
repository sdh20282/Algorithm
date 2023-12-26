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
    let cross_count = 1, prev_count_sum = 0;

    while (true) {
      if (input <= prev_count_sum + cross_count) {
        if (cross_count % 2 == 1) {
          console.log((cross_count - (input - prev_count_sum - 1)) + "/" + (input - prev_count_sum));

          break;
        } else {
          console.log((input - prev_count_sum) + "/" + (cross_count - (input - prev_count_sum - 1)));

          break;
        }

      } else {
        prev_count_sum += cross_count;
        cross_count++;
      }
    }
  });

