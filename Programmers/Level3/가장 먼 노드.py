from collections import deque


def solution(n, edge):
    vertex = {}
    lengths = [20000 for _ in range(n + 1)]

    for s, e in sorted(edge):
        ways = vertex.get(s, [])
        ways.append(e)
        vertex[s] = ways

        ways = vertex.get(e, [])
        ways.append(s)
        vertex[e] = ways

    lengths[0] = 0
    lengths[1] = 0
    q = deque()
    ways = vertex.get(1)

    for way in ways:
        q.append([way, 1])

    while q:
        now, length = q.popleft()

        if lengths[now] <= length:
            continue

        if lengths[now] > length:
            lengths[now] = length

        ways = vertex.get(now) 

        for way in ways:
            q.append([way, length + 1])

    return lengths.count(max(lengths))
