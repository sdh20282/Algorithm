const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = '';

function solution(str) {
  let answer = 0;

  function recur(str) {
    if (str < 10) {
      return str;
    }

    str = String(str).split('').reduce((acc, cur) => acc + (+cur), 0);
    answer++;

    return recur(str);
  }

  recur(str);

  return [answer, recur(str) % 3 === 0 ? 'YES' : 'NO']
}

readline
  .on('line', (line) => {
    input = line;
  })
  .on('close', () => {
    console.log(solution(input).join('\n'));

    process.exit();
  });
