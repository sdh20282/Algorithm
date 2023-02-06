from collections import deque


def solution(n, computers):
    nodes = [0 for _ in range(n)]

    q = deque()
    network = 1

    for i in range(n):
        q.append(computers[i])

        while q:
            link = q.popleft()

            for j in range(n):
                if link[j] == 0:
                    continue

                if nodes[j] != 0:
                    continue

                nodes[j] = network

                if i != j:
                    q.append(computers[j])

        network += 1

    return len(set(nodes))
