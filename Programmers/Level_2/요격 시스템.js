function solution(targets) {
  targets.sort((a, b) => a[0] - b[0]);

  let answer = 1;
  let [s, e] = [-1, 100000001];

  for (const target of targets) {
    const [t_s, t_e] = target;

    if (t_s >= s && t_e <= e) {
      [s, e] = [t_s, t_e];
    } else if (t_s < e && t_e > e) {
      [s, e] = [t_s, e];
    } else {
      answer += 1;
      [s, e] = [t_s, t_e];
    }
  }

  return answer;
}
