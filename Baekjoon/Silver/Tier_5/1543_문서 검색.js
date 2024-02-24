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
    let [doc, search] = input;
    let cnt = 0;
    let idx = 0;

    while (idx >= 0) {
      idx = doc.indexOf(search);

      if (idx >= 0) {
        doc = doc.slice(idx + search.length, doc.length);
        cnt++;
      }
    }

    console.log(cnt);
    process.exit();
  });

