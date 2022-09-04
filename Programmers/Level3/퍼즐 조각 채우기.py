r_move = [0, 0, -1, 1]
c_move = [-1, 1, 0, 0]


def find_puzzle(r, c, table, checked, idx):
    puzzle = []
    count = 0
    n = len(table)
    q = [[r, c]]
    checked[r][c] = True

    while q:
        r_cur, c_cur = q.pop()
        puzzle.append([r_cur, c_cur])
        count += 1

        for i in range(4):
            r_next, c_next = r_cur + r_move[i], c_cur + c_move[i]

            if 0 <= r_next < n and 0 <= c_next < n:
                if table[r_next][c_next] == idx and not checked[r_next][c_next]:
                    checked[r_next][c_next] = True
                    q.append([r_next, c_next])

    return transform_matrix(puzzle), count


def transform_matrix(puzzle):
    r_min, r_max = 100, -1
    c_min, c_max = 100, -1

    for location in puzzle:
        r, c = location
        r_min = min(r_min, r)
        r_max = max(r_max, r)
        c_min = min(c_min, c)
        c_max = max(c_max, c)

    r_size = r_max - r_min + 1
    c_size = c_max - c_min + 1

    puzzle_matrix = [[0] * c_size for _ in range(r_size)]

    for location in puzzle:
        r, c = location
        puzzle_matrix[r - r_min][c - c_min] = 1

    return puzzle_matrix


def rotation(puzzle):
    r = len(puzzle)
    c = len(puzzle[0])
    rotated_puzzles = []
    cur_puzzle = puzzle

    for i in range(4):
        rotated_puzzle = [[0] * r for _ in range(c)]

        for r_cur in range(r):
            for c_cur in range(c):
                rotated_puzzle[c_cur][r - r_cur - 1] = cur_puzzle[r_cur][c_cur]

        cur_puzzle = rotated_puzzle
        rotated_puzzles.append(rotated_puzzle)
        r, c = c, r

    return rotated_puzzles


def is_match(board_blanks, puzzles, puzzle_blocks):
    result = 0

    blank_match = [False for _ in range(len(board_blanks))]
    puzzle_match = [False for _ in range(len(puzzles))]

    for blank_idx, board_blank in enumerate(board_blanks):
        for puzzle_idx, puzzle in enumerate(puzzles):
            for rotation_puzzle in puzzle:
                if (len(board_blank) == len(rotation_puzzle)) and (len(board_blank[0]) == len(rotation_puzzle[0])):
                    if rotation_puzzle == board_blank:
                        if not blank_match[blank_idx] and not puzzle_match[puzzle_idx]:
                            blank_match[blank_idx] = True
                            puzzle_match[puzzle_idx] = True
                            result += puzzle_blocks[puzzle_idx]

    return result


def solution(game_board, table):
    answer = 0
    puzzles = []
    board_blanks = []
    n = len(game_board)
    checked_table = [[False] * n for _ in range(n)]
    checked_board = [[False] * n for _ in range(n)]
    puzzle_blocks = []

    for r in range(n):
        for c in range(n):
            if table[r][c] == 1 and checked_table[r][c] == False:
                puzzle, count = find_puzzle(r, c, table, checked_table, 1)
                puzzles.append(rotation(puzzle))
                puzzle_blocks.append(count)

    for r in range(n):
        for c in range(n):
            if game_board[r][c] == 0 and checked_board[r][c] == False:
                board_blank, temp = find_puzzle(r, c, game_board, checked_board, 0)
                board_blanks.append(board_blank)

    result = is_match(board_blanks, puzzles, puzzle_blocks)

    return result
