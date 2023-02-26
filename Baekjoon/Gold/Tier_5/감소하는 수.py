target = int(input())
com = [-1 for _ in range(10)]
visited = [False for _ in range(10)]
combs = []

def getComb(cur, index, prev, now):
    if cur == now:
        number = ""

        for i in range(now):
            number += str(com[i])

        combs.append(int(number))
        return

    for i in range(prev, -1, -1):
        if visited[i]:
            continue

        visited[i] = True
        com[index] = i
        getComb(cur + 1, index + 1, i - 1, now)
        visited[i] = False

for now in range(1, 11):
    getComb(0, 0, 9, now)

combs.sort()

try:
    print(combs[target])
except:
    print(-1)
