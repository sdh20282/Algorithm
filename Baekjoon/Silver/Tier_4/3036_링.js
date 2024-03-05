const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

const GCD = (num1, num2) => {
  let gcd = 1;

  for (let i = 2; i <= Math.min(num1, num2); i++) {
    if (num1 % i === 0 && num2 % i === 0) {
      gcd = i;
    }
  }

  return gcd;
}

readline
  .on('line', (line) => {
    input.push(line.split(" ").map(Number));
  })
  .on('close', () => {
    let [N, nums] = input;
    const first = nums.shift();

    nums.forEach(num => {
      const gcd = GCD(first, num);

      console.log((first / gcd) + '/' + (num / gcd))
    })

    process.exit();
  });

