function solution(coin, cards) {
  const sum = cards.length + 1;
  const having = {};
  const pair = {};
  let answer = 1;

  const updateCard = (target) => {
    const opponent = sum - target;

    if (having[opponent] !== undefined) {
      !pair[having[opponent] + having[target]] ? pair[having[opponent] + having[target]] = 0 : 1;
      pair[having[opponent] + having[target]] += 1;
    }
  }

  for (let i = 0; i < cards.length / 3; i++) {
    having[cards[i]] = 0;

    updateCard(cards[i]);
  }

  for (let i = cards.length / 3; i < cards.length; i += 2) {

    having[cards[i]] = 1;
    having[cards[i + 1]] = 1;

    updateCard(cards[i]);
    updateCard(cards[i + 1]);

    if (pair[0] >= 1) {
      pair[0] -= 1;
      answer += 1;

      continue;
    }

    if (pair[1] >= 1 && coin >= 1) {
      pair[1] -= 1;
      coin -= 1;
      answer += 1;

      continue;
    }

    if (pair[2] >= 1 && coin >= 2) {
      pair[2] -= 1;
      coin -= 2;
      answer += 1;

      continue;
    }

    break;
  }

  return answer;
}
