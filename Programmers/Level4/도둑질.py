def count(money, results):
    for i in range(2, len(money)):
        results[i] = max(results[i - 2] + money[i], results[i - 1])

    return results


def solution(money):
    answer = []
    
    results = [0 for _ in range(len(money))]
    results[0] = money[0]
    results[1] = results[0]

    results = count(money, results)
    answer.append(results[len(money) - 2])

    results[0] = 0
    results[1] = money[1]

    results = count(money, results)
    answer.append(results[len(money) - 1])

    results[0] = 0
    results[1] = 0

    results = count(money, results)
    answer.append(results[len(money) - 1])

    return max(answer)
