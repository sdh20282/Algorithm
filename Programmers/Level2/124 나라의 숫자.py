to_124 = ['1', '2', '4']


def solution(n):
    answer = ''

    while n != 0:
        n -= 1
        answer = to_124[n % 3] + answer
        n = n // 3

    return answer
