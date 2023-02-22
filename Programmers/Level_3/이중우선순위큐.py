def solution(operations):
    q = []
    answer = []

    for operation in operations:
        command, number = operation.split(' ')
        number = int(number)

        if command == 'I':
            q.append(number)
            
            answer = [max(q), min(q)]
        else:
            if not q:
                answer = [0, 0]
                continue

            if number == 1:
                q.remove(max(q))
            else:
                q.remove(min(q))

            if not q:
                answer = [0, 0]
                continue

            answer = [max(q), min(q)]

    return answer
