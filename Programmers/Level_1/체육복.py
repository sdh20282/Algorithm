def solution(n, lost, reserve):
    removed_lost = sorted([i for i in lost if i not in reserve])
    removed_reserve = sorted([i for i in reserve if i not in lost])
    answer = 0

    for lo in removed_lost:
        if lo - 1 in removed_reserve:
            removed_reserve.remove(lo - 1)
            answer += 1
        elif lo + 1 in removed_reserve:
            removed_reserve.remove(lo + 1)
            answer += 1

    return n - len(removed_lost) + answer
