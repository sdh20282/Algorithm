def solution(progresses, speeds):
    answer = []

    while progresses:
        count = 0

        while progresses[0] < 100:
            progresses = list(map(lambda x, y: x + y, progresses, speeds))

        for i in range(len(progresses)):
            if progresses[i] >= 100:
                count += 1
            else:
                break

        for j in range(count):
            progresses.pop(0)
            speeds.pop(0)

        answer.append(count)

    return answer
