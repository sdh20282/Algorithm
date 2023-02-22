def solution(n, times):
    left, right = 1, max(times) * n

    while right > left:
        mid = (left + right) // 2
        count = 0

        for time in times:
            count += mid // time

        if count < n:
            left = mid + 1
        else:
            right = mid

    return right
