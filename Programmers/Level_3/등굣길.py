def solution(m, n, puddles):
    array = [[1 for _ in range(m + 1)] for _ in range(n + 1)]

    for puddle in puddles:
        x, y = puddle
        array[y][x] = 0

    for r in range(1, n + 1):
        if array[r][1] == 0:
            for r_zero in range(r, n + 1):
                array[r_zero][1] = 0

            break

    for c in range(1, m + 1):
        if array[1][c] == 0:
            for c_zero in range(c, m + 1):
                array[1][c_zero] = 0

            break

    for r in range(2, n + 1):
        for c in range(2, m + 1):
            if array[r][c] == 0:
                continue

            array[r][c] = array[r][c - 1] + array[r - 1][c]

    return array[n][m] % 1000000007
