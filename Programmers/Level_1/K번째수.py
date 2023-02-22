def solution(array, commands):
    answer = []

    for start, end, idx in commands:
        sliced = array[start - 1 : end]
        sliced.sort()
        answer.append(sliced[idx - 1])

    return answer
