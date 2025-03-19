function solution(people, limit) {
  let count = 0;
  let [left, right] = [0, people.length - 1];

  people.sort((a, b) => a - b);

  while (left <= right) {
    let currentLimit = limit;

    if (currentLimit >= people[right]) {
      currentLimit -= people[right];
      right--;
    }

    if (currentLimit >= people[left]) {
      left++;
    }

    count++;
  }

  return count;
}
