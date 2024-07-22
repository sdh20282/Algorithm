function dp(target) {
  const len = target.length + 2;
  const arr = new Array(len).fill(0);

  for (let i = 2; i < len; i++) {
    arr[i] = Math.max(arr[i - 1], arr[i - 2] + target[i - 2]);
  }

  return arr[len - 1];
}

function solution(sticker) {
  if (sticker.length === 1) {
    return sticker[0];
  }

  return Math.max(dp(sticker.slice(0, -1)), dp(sticker.slice(1)));
}
