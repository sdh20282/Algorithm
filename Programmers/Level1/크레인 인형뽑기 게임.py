def solution(board, moves):
    dolls = []
    answer = 0

    for move in moves:
        doll = 0

        for height in range(len(board)):
            if board[height][move - 1] != 0:
                doll = board[height][move - 1]
                board[height][move - 1] = 0
                break

        if doll == 0:
            continue

        if len(dolls) == 0:
            dolls.append(doll)
        else:
            if dolls[len(dolls) - 1] != doll:
                dolls.append(doll)
            else:
                dolls.pop()
                answer += 2

    return answer
