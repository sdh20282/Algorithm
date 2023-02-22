from collections import deque


def solution(n, wires):
    answer = 100
    graph = [[] for _ in range(n + 1)]

    for a, b in wires:
        graph[a].append(b)
        graph[b].append(a)

    for start_node, delete_node in wires:
        visited = [False for _ in range(n + 1)]
        result = 1
        q = deque()
        q.append(start_node)
        visited[start_node] = visited[delete_node] = True

        while q:
            now_node = q.popleft()

            for connected_node in graph[now_node]:
                if not visited[connected_node]:
                    q.append(connected_node)
                    visited[connected_node] = True
                    result += 1

        if answer > abs(n - 2 * result):
            answer = abs(n - 2 * result)

    return answer
