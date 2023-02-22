def solution(a, b, n):
    count = 0

    while n >= a:
        cola = n // a * b
        count += cola
        n = n % a + cola

    return count
