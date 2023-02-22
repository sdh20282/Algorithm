from collections import deque


def solution(board, r, c):
    match = {}

    for row in range(4):
        for col in range(4):
            if board[row][col] != 0:
                location = match.get(board[row][col], [])
                location.append([row, col])
                match[board[row][col]] = location

    for character in match:
        location = match.get(character)

        if location[0][0] == location[1][0] or location[0][1] == location[1][1]:
            location.append(3)
        else:
            location.append(4)

        match[character] = location

    q = deque()
    visited = [False for _ in range(len(match) + 1)]
    q.append([r, c, 0, visited])
    answer = 100

    while q:
        row, col, count, visited = q.popleft()

        end = True

        for character in match:
            if not visited[character]:
                end = False

        if end:
            if count < answer:
                answer = count
                continue

        for character in match:
            location = match[character]

            if visited[character]:
                continue

            next_visited = visited.copy()
            next_visited[character] = True

            if location[0] == [row, col]:
                q.append([location[1][0], location[1][1], count + location[2], next_visited])
            elif location[1] == [row, col]:
                q.append([location[0][0], location[0][1], count + location[2], next_visited])

            elif location[0][0] == row or location[0][1] == col:
                q.append([location[1][0], location[1][1], count + location[2] + 1, next_visited])
            elif location[1][0] == row or location[1][1] == col:
                q.append([location[0][0], location[0][1], count + location[2] + 1, next_visited])
            
            q.append([location[1][0], location[1][1], count + location[2] + 2, next_visited])
            q.append([location[0][0], location[0][1], count + location[2] + 2, next_visited])

    return answer
