from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def solution(rectangle, characterX, characterY, itemX, itemY):
    for rect in rectangle:
        for i in range(4):
            rect[i] *= 2
    characterX *= 2
    characterY *= 2
    itemX *= 2
    itemY *= 2
    visited = [[False] * 110 for _ in range(110)]
    result = 1000

    q = deque([[characterX, characterY, 0]])

    while q:
        curX, curY, count = q.popleft()
        visited[curX][curY] = True

        if curX == itemX and curY == itemY and result > count:
            result = count
            continue

        for i in range(4):
            nextX = curX + dx[i]
            nextY = curY + dy[i]

            if not (0 <= nextX <= 100 and 0 <= nextY <= 100):
                continue

            if visited[nextX][nextY]:
                continue

            isEdge = False

            for rect in rectangle:
                x_min, y_min, x_max, y_max = rect

                if (nextX < x_min or nextX > x_max) or (nextY < y_min or nextY > y_max):
                    continue

                if x_min < nextX < x_max and y_min < nextY < y_max:
                    isEdge = False
                    break

                isEdge = True

            if isEdge:
                q.append([nextX, nextY, count + 1])

    return result // 2
