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
    let [N, ...arr] = input;

    let maxCount = 0;
    let maxName = "";
    const dict = {};

    arr.forEach(name => {
      if (dict[name]) {
        dict[name]++;
      }
      else {
        dict[name] = 1;
      }

      if (dict[name] === maxCount && name < maxName) {
        maxName = name;
      }
      else if (dict[name] > maxCount) {
        maxName = name;
        maxCount = dict[name];
      }
    });

    console.log(maxName);
    process.exit();
  });

