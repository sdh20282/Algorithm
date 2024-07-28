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

    this.size++;
  }

  deque() {
    if (this.size === 0) {
      return;
    }

    const node = this.start;

    this.start = this.start.next;
    this.size--;

    return node.value;
  }
}

function solution(n, s, a, b, fares) {
  const pathes = {};

  for (let i = 1; i <= n; i++) {
    pathes[i] = [];
  }

  const costs = new Array(n + 1).fill(0).map(_ => new Array(n + 1).fill(0));

  for (const fare of fares) {
    const [p1, p2, cost] = fare;

    costs[p1][p2] = cost;
    costs[p2][p1] = cost;

    pathes[p1].push(p2);
    pathes[p2].push(p1);
  }

  const min_cost_s = new Array(n + 1).fill(-1);
  const min_cost_a = new Array(n + 1).fill(-1);
  const min_cost_b = new Array(n + 1).fill(-1);

  min_cost_s[s] = 0;
  min_cost_a[a] = 0;
  min_cost_b[b] = 0;

  const getCosts = (target, start) => {
    const q = new Queue();

    target[start] = 0;
    q.enque([start, 0]);

    while (q.size > 0) {
      const [node, cost] = q.deque();

      for (const path of pathes[node]) {
        const nextCost = cost + costs[node][path];

        if (target[path] === -1 || target[path] > nextCost) {
          target[path] = nextCost;
          q.enque([path, nextCost]);
        }
      }
    }
  }

  getCosts(min_cost_s, s);
  getCosts(min_cost_a, a);
  getCosts(min_cost_b, b);

  let minCost = Infinity;

  for (let i = 1; i <= n; i++) {
    if (min_cost_s[i] === -1 || min_cost_a[i] === -1 || min_cost_b[i] === -1) {
      continue;
    }

    const nowCost = min_cost_s[i] + min_cost_a[i] + min_cost_b[i];

    if (nowCost < minCost) {
      minCost = nowCost;
    }
  }

  return minCost;
}
