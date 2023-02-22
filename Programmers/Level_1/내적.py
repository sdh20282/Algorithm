def solution(a, b):
    return sum(_a * _b for _a, _b in zip(a, b))
