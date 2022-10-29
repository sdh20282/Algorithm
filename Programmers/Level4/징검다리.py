def solution(distance, rocks, n):
    rocks.sort()
    distances = []

    prev = 0
    for rock in rocks:
        distances.append(rock - prev)
        prev = rock
    distances.append(distance - prev)

    start, end = 0, distance

    while end - start > 1:
        mid = (start + end) // 2
        now_distances = distances.copy()
        current = removed = 0

        for now_distance in now_distances:
            current += now_distance
            if current < mid:
                removed += 1
            else:
                current = 0

        if removed <= n:
            start = mid
        else:
            end = mid - 1

    return end
