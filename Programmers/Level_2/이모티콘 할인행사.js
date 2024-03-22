const rates = [10, 20, 30, 40];

function solution(users, emoticons) {
  const discounts = {};

  emoticons.forEach((emoticon, idx) => {
    const calculate = {};

    rates.forEach(rate => {
      calculate[rate] = emoticon * (1 - rate / 100);
    })

    discounts[idx] = calculate;
  });

  let result = [0, 0];
  const selected = new Array(emoticons.length).fill(0);

  const check = () => {
    let emoticonPlus = 0;
    let emoticonCost = 0;

    users.forEach(user => {
      const [rate, total] = user;
      let cost = 0;

      selected.forEach((sel, idx) => {
        if (sel >= rate) {
          cost += discounts[idx][sel];
        }
      });

      if (cost >= total) {
        emoticonPlus += 1;
      } else {
        emoticonCost += cost;
      }
    });

    if (emoticonPlus > result[0] || (emoticonPlus === result[0] && emoticonCost > result[1])) {
      result = [emoticonPlus, emoticonCost];
    }
  }

  const comb = (n) => {
    if (n === emoticons.length) {
      check();

      return;
    }

    rates.forEach(rate => {
      selected[n] = rate;
      comb(n + 1);
    });
  }

  comb(0);

  return result;
}
