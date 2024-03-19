function solution(edges) {
  const edgeCount = {};

  edges.forEach(edge => {
    const [from, to] = edge;

    !edgeCount[from] ? edgeCount[from] = { input: 0, output: 0 } : 1;
    !edgeCount[to] ? edgeCount[to] = { input: 0, output: 0 } : 1;

    edgeCount[from].output += 1;
    edgeCount[to].input += 1;
  });

  const answer = [0, 0, 0, 0];

  Object.keys(edgeCount).forEach(key => {
    const now = edgeCount[key];

    if (now.input === 1 && now.output === 1) {
      return;
    }

    if (now.input === 0 && now.output >= 2) {
      answer[0] = key * 1;
    }

    if (now.input >= 2 && now.output === 2) {
      answer[3] += 1;
    }

    if (now.output === 0) {
      answer[2] += 1;
    }
  });

  answer[1] = edgeCount[answer[0]].output - answer[2] - answer[3];

  return answer;
}
