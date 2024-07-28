class Node {
  constructor(idx, prev, next) {
    this.idx = idx;
    this.prev = prev;
    this.next = next;
    this.state = 'O';
  }
}

function solution(n, k, cmd) {
  const nodeList = new Array(n).fill(0).map((_, idx) => new Node(idx, idx - 1, idx + 1));

  nodeList[0].prev = null;
  nodeList[n - 1].next = null;

  const deleted = [];

  const u = (k, x) => {
    for (let _ = 0; _ < x; _++) {
      if (nodeList[k].prev === null) {
        break;
      }

      k = nodeList[k].prev;
    }

    return k;
  }

  const d = (k, x) => {
    for (let _ = 0; _ < x; _++) {
      if (nodeList[k].next === null) {
        break;
      }

      k = nodeList[k].next;
    }

    return k;
  }

  const c = (k, x) => {
    deleted.push(k);
    nodeList[k].state = 'X';

    if (nodeList[k].prev !== null) {
      nodeList[nodeList[k].prev].next = nodeList[k].next;
    }

    if (nodeList[k].next !== null) {
      nodeList[nodeList[k].next].prev = nodeList[k].prev;
    }

    return nodeList[k].next ? nodeList[k].next : nodeList[k].prev;
  }

  const z = (k, x) => {
    const t = deleted.pop();
    nodeList[t].state = 'O';

    if (nodeList[t].prev !== null) {
      nodeList[nodeList[t].prev].next = t;
    }

    if (nodeList[t].next !== null) {
      nodeList[nodeList[t].next].prev = t;
    }

    return k;
  }

  const commands = {
    'U': u,
    'D': d,
    'C': c,
    'Z': z,
  }

  for (const command of cmd) {
    const c = command.split(" ");

    k = commands[c[0]](k, c.length !== 1 ? c[1] : 0);
  }

  let answer = '';

  for (const node of nodeList) {
    answer += node.state;
  }

  return answer;
}
