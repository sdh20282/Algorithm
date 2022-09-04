def operations(A, B):
    operation_result = set()

    for a in A:
        for b in B:
            operation_result.add(a + b)
            operation_result.add(a - b)
            operation_result.add(a * b)

            if b != 0:
                operation_result.add(a // b)

    return operation_result


def solution(N, number):
    answer = -1

    if N == number:
        return 1

    stage = {}
    stage[1] = {N}

    for now in range(2, 9):
        idx = 1
        result_set = set()
        result_set.add(int(str(N) * now))

        while idx < now:
            result_set.update(operations(stage[idx], stage[now - idx]))
            idx += 1

        if number in result_set:
            answer = now
            break

        stage[now] = result_set

    return answer
