function solution(dice) {
  const indexes = new Array(dice.length).fill(0).map((_, i) => i);
  const combinations = [];
  const r = dice.length / 2;

  const combination = (items, idx) => {
    if (items.length === r) {
      combinations.push(items);

      return;
    }

    for (let i = idx; i < indexes.length; i++) {
      combination([...items, indexes[i]], i + 1);
    }
  }

  combination([], 0);

  const rollDice = (ary, dice, map) => {
    if (ary.length === dice.length) {
      const sum = ary.reduce((a, c) => a + c, 0);

      if (map.get(sum)) {
        map.set(sum, map.get(sum) + 1)
      }
      else {
        map.set(sum, 1)
      }

      return;
    }

    for (let i = 0; i < 6; i++) {
      ary.push(dice[ary.length][i]);
      rollDice(ary, dice, map);
      ary.pop();
    }
  }

  let answer = [];
  let count = 0;

  for (const aAry of combinations) {
    const aDice = aAry.map(v => dice[v]);
    const bDice = indexes.filter(v => !aAry.includes(v)).map(v => dice[v]);

    const aMap = new Map();
    const bMap = new Map();

    rollDice([], aDice, aMap);
    rollDice([], bDice, bMap);

    let result = 0

    for (const [aCurSum, aCnt] of aMap) {
      for (const [bCurSum, bCnt] of bMap) {
        if (aCurSum > bCurSum) {
          result += aCnt * bCnt;
        }
      }
    }

    if (result > count) {
      answer = aAry;
      count = result;
    }
  }

  return answer.map(e => e + 1);
}
