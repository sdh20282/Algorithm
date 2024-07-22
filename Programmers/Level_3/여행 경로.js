function solution(tickets) {
  tickets.sort();

  const result = [];
  const visited = [];

  const len = tickets.length;

  const dfs = (airport, count) => {
    result.push(airport);

    if (count === len) {
      return true;
    }

    for (let i = 0; i < len; i++) {
      if (visited[i] || tickets[i][0] !== airport) {
        continue;
      }

      visited[i] = true;

      if (dfs(tickets[i][1], count + 1)) {
        return true;
      }

      visited[i] = false;
    }

    result.pop();

    return false;
  }

  dfs("ICN", 0);

  return result;
}
