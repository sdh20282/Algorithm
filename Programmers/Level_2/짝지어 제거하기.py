def solution(s):
    q = []

    for i in range(len(s)):
        if q:
            if q[len(q) - 1] == s[i]:
                q.pop()
                continue

        q.append(s[i])

    return 1 if not q else 0
