import math
from collections import deque


def solution(info, edges):
    paths = {}
    answer = -math.inf

    for edge in edges:
        path = paths.get(edge[0], [])
        path.append(edge[1])
        paths[edge[0]] = path

    q = deque()
    visited_nodes = [False for _ in range(len(info))]
    movable_nodes = paths.get(0)
    q.append([0, 0, 0, visited_nodes.copy(), movable_nodes.copy()])

    while q:
        now_location, sheep_count, wolf_count, now_visited, now_movable = q.popleft()

        if info[now_location]:
            wolf_count += 1
        else:
            sheep_count += 1

        if wolf_count >= sheep_count:
            continue

        now_visited[now_location] = True
        answer = max(answer, sheep_count)

        for movable in now_movable:
            next_movable = now_movable.copy()
            next_movable.remove(movable)

            for path in paths.get(movable, []):
                next_movable.append(path)

            now_state = [movable, sheep_count, wolf_count, now_visited.copy(), next_movable]

            if now_state not in q:
                q.append(now_state)


    return answer
