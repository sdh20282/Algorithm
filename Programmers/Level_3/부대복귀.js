class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.start = null;
    this.end = null;
    this.size = 0;
  }

  enque(value) {
    const node = new Node(value);

    if (this.size === 0) {
      this.start = node;
      this.end = node;
    } else {
      this.end.next = node;
      this.end = node;
    }

    this.size += 1;
  }

  deque() {
    if (this.size === 0) {
      return null;
    }

    const value = this.start.value;

    this.start = this.start.next;
    this.size -= 1;

    return value;
  }
}

function solution(n, roads, sources, destination) {
  const roadInfo = {};

  for (let i = 0; i < n; i++) {
    roadInfo[i + 1] = [];
  }

  for (const road of roads) {
    const [a, b] = road;

    roadInfo[a].push(b);
    roadInfo[b].push(a);
  }

  const distances = new Array(n + 1).fill(-1);
  distances[destination] = 0;

  const q = new Queue();
  q.enque([destination, 0]);

  while (q.size > 0) {
    const [curNode, count] = q.deque();

    roadInfo[curNode].forEach(nextNode => {
      if (distances[nextNode] === -1 || distances[nextNode] > count + 1) {
        distances[nextNode] = count + 1;
        q.enque([nextNode, count + 1]);
      }
    });
  }

  const answer = [];

  for (const source of sources) {
    answer.push(distances[source]);
  }

  return answer;
}
