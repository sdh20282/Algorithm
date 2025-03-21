const cumulativeNodesToNumber = (cumulativeNodes) => {
  return parseInt(new Array(cumulativeNodes).fill('1').join(''), 2)
}

const dfs = (binary, center, check) => {
  if (check === 0) {
    return true;
  }

  const gap = (check - 1) / 2 + 1;

  if (binary[center] === '0' && (binary[center + gap] === '1' || binary[center - gap] === '1')) {
    return false;
  }

  return dfs(binary, center - gap, (check - 1) / 2) && dfs(binary, center + gap, (check - 1) / 2);
}

function solution(numbers) {
  const results = [];

  for (const number of numbers) {
    let cumulativeNodes = 1;
    let leafNodes = 1;

    while (cumulativeNodesToNumber(cumulativeNodes) < number) {
      leafNodes *= 2;
      cumulativeNodes += leafNodes;
    }

    let numberToBinary = number.toString(2);

    if (numberToBinary.length < cumulativeNodes) {
      const gap = cumulativeNodes - numberToBinary.length;

      numberToBinary = new Array(gap).fill('0').join('') + numberToBinary;
    }

    const result = dfs(numberToBinary, (numberToBinary.length - 1) / 2, (numberToBinary.length - 1) / 2);

    if (result) {
      results.push(1);
    } else {
      results.push(0);
    }
  }

  return results;
}
