import sys


def dynamic(start, a, b, c):
    for i in range(start, N):
        a[i + 1] = min(b[i] + 1, c[i] + 1)

        if small_circle[i] + large_circle[i] <= W:
            a[i + 1] = min(a[i] + 1, a[i + 1])

        if i > 0 and small_circle[i - 1] + small_circle[i] <= W and large_circle[i - 1] + large_circle[i] <= W:
            a[i + 1] = min(a[i + 1], a[i - 1] + 2)

        if i < N - 1:
            b[i + 1] = a[i + 1] + 1

            if small_circle[i] + small_circle[i + 1] <= W:
                b[i + 1] = min(b[i + 1], c[i] + 1)

            c[i + 1] = a[i + 1] + 1

            if large_circle[i] + large_circle[i + 1] <= W:
                c[i + 1] = min(c[i + 1], b[i] + 1)


T = int(sys.stdin.readline())

for _ in range(T):
    N, W = map(int, sys.stdin.readline().split())
    small_circle = list(map(int, sys.stdin.readline().split()))
    large_circle = list(map(int, sys.stdin.readline().split()))

    a = [0 for _ in range(N + 1)]
    b = [0 for _ in range(N + 1)]
    c = [0 for _ in range(N + 1)]

    a[0] = 0
    b[0] = 1
    c[0] = 1

    dynamic(0, a, b, c)
    res = a[N]

    if N > 1 and small_circle[0] + small_circle[N - 1] <= W:
        a[1] = 1
        b[1] = 2

        if large_circle[0] + large_circle[1] <= W:
            c[1] = 1
        else:
            c[1] = 2

        dynamic(1, a, b, c)
        res = min(res, c[N - 1] + 1)

    if N > 1 and large_circle[0] + large_circle[N - 1] <= W:
        a[1] = 1
        c[1] = 2

        if small_circle[0] + small_circle[1] <= W:
            b[1] = 1
        else:
            b[1] = 2

        dynamic(1, a, b, c)
        res = min(res, b[N - 1] + 1)

    if N > 1 and small_circle[0] + small_circle[N - 1] <= W and large_circle[0] + large_circle[N - 1] <= W:
        a[1] = 0
        b[1] = 1
        c[1] = 1

        dynamic(1, a, b, c)
        res = min(res, a[N - 1] + 2)

    print(res)
