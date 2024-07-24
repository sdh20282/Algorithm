function solution(s) {
  const chars = s.split('');

  for (let len = chars.length; len > 1; len--) {
    check: for (let i = 0; i <= chars.length - len; i++) {
      for (let j = i; j < i + parseInt(len / 2); j++) {
        if (chars[j] !== chars[len - j - 1 + i + i]) {
          continue check;
        }
      }

      return len;
    }
  }

  return 1;
}
