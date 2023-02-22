def solution(board, skills):
    answer = 0
    row = len(board)
    col = len(board[0])
    total = [[0 for _ in range(col)] for _ in range(row)]

    for skill in skills:
        sign = 1

        if skill[0] == 1:
            sign = -1

        total[skill[1]][skill[2]] += sign * skill[5]

        if skill[3] + 1 < row:
            total[skill[3] + 1][skill[2]] -= sign * skill[5]

        if skill[4] + 1 < col:
            total[skill[1]][skill[4] + 1] -= sign * skill[5]

        if skill[3] + 1 < row and skill[4] + 1 < col:
            total[skill[3] + 1][skill[4] + 1] += sign * skill[5]

    for r in range(row):
        for c in range(1, col):
            total[r][c] += total[r][c - 1]

    for r in range(1, row):
        for c in range(col):
            total[r][c] += total[r - 1][c]

    for r in range(row):
        for c in range(col):
            if board[r][c] + total[r][c] > 0:
                answer += 1

    return answer
