def solution(n, s):
    if s < n:
        return [-1]

    answer = [s // n for _ in range(n)]
    s = s % n

    for i in range(s):
        answer[i] += 1

    return sorted(answer)
