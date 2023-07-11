from itertools import combinations
import sys

N, M = map(int, input().split())
Map = [list(map(int, input().split())) for _ in range(N)]

homes = []
chickens = []

for r in range(N):
    for c in range(N):
        if Map[r][c] == 1:
            homes.append([r, c])

        if Map[r][c] == 2:
            chickens.append([r, c])

combs = list(combinations(chickens, M))
rst = sys.maxsize

for comb in combs:
    total = 0

    for home in homes:
        min_val = sys.maxsize

        for now in comb:
            min_val = min(min_val, abs(home[0] - now[0]) + abs(home[1] - now[1]))

        total += min_val

    rst = min(rst, total)

print(rst)
