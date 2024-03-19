function solution(friends, gifts) {
  const records = {};

  friends.forEach(friend => {
    records[friend] = { degree: 0, count: 0 };
  });

  gifts.forEach(gift => {
    const [from, to] = gift.split(" ");

    records[from].degree += 1;
    records[to].degree -= 1;

    !records[from][to] ? records[from][to] = 0 : 1;
    records[from][to] += 1;
  });

  let max = 0;

  friends.forEach(target => {
    let count = 0;

    friends.forEach(friend => {
      if (target === friend) {
        return;
      }

      const give = records[target][friend] ?? 0;
      const take = records[friend][target] ?? 0;

      if (give === take && records[target].degree > records[friend].degree || give > take) {
        count += 1;
      }
    });

    if (count > max) {
      max = count;
    }
  });

  return max;
}
