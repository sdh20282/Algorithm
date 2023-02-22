def solution(rows, columns, queries):
    matrix = [[j * columns + i + 1 for i in range(columns)] for j in range(rows)]
    answer = []

    for query in queries:
        r_start, c_start, r_end, c_end = query

        min_val = rows * columns
        tmp = matrix[r_start - 1][c_end - 1]

        min_val = tmp

        for i in range(c_end - 1, c_start - 1, -1):
            if min_val > matrix[r_start - 1][i]:
                min_val = matrix[r_start - 1][i]

            matrix[r_start - 1][i] = matrix[r_start - 1][i - 1]

        for i in range(r_start - 1, r_end - 1):
            if min_val > matrix[i][c_start - 1]:
                min_val = matrix[i][c_start - 1]

            matrix[i][c_start - 1] = matrix[i + 1][c_start - 1]

        for i in range(c_start - 1, c_end - 1):
            if min_val > matrix[r_end - 1][i]:
                min_val = matrix[r_end - 1][i]

            matrix[r_end - 1][i] = matrix[r_end - 1][i + 1]

        for i in range(r_end - 1, r_start - 1, -1):
            if min_val > matrix[i][c_end - 1]:
                min_val = matrix[i][c_end - 1]

            matrix[i][c_end - 1] = matrix[i - 1][c_end - 1]

        matrix[r_start][c_end - 1] = tmp

        answer.append(min_val)

    return answer
