def solution(priorities, location):
    answer = 1

    while True:
        now = priorities.pop(0)

        if len(priorities) == 0:
            break

        max_priority = max(priorities)

        if now >= max_priority and location == 0:
            break

        if now >= max_priority:
            if location == 0:
                location = len(priorities) - 1
            else:
                location -= 1

        if now < max_priority:
            priorities.append(now)

            if location == 0:
                location = len(priorities) - 1
            else:
                location -= 1

            continue

        answer += 1

    return answer
