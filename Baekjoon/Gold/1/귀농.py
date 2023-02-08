from sys import stdin

dp = [[-1, -1], [-1, 1], [1, -1], [1, 1]]

n = int(stdin.readline())
maps = [[0 for _ in range(n)] for _ in range(n)]

for i in range(n):
    maps[i] = list(map(int, stdin.readline().split()))


def count_point(y, x):
    point_count = 0

    for direction in range(2):
        dy, dx = dp[direction]
        left = get_counts(y, x, dy, dx)

        dy, dx = dp[3 - direction]
        right = get_counts(y, x, dy, dx)

        for l in left:
            for r in right:
                if l == r:
                    point_count += 1

    return point_count


def get_counts(y, x, dy, dx):
    results =[]
    count_maps = [[0 for _ in range(n)] for _ in range(n)]

    for i in range(y + 1 if dy > 0 else y, n if dy > 0 else -1, dy):
        now_sum = 0

        for j in range(x + 1 if dx > 0 else x, n if dx > 0 else -1, dx):
            now_sum += maps[i][j]
            count_maps[i][j] += count_maps[i - dy][j] + now_sum
            results.append(count_maps[i][j])

    return results


count = 0

for i in range(n - 1):
    for j in range(n - 1):
        count += count_point(i, j)

print(count)
