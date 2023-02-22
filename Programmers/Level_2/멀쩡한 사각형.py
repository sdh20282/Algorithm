from math import gcd


def solution(w, h):
    greatest_common_divisor = gcd(w, h)
    answer = w / greatest_common_divisor + h / greatest_common_divisor - 1

    return int(w * h - greatest_common_divisor * answer)
