a = [1, 2, 3, 4, 5]
b = [2, 1, 2, 3, 2, 4, 2, 5]
c = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]


def solution(answers):
    answer = []
    abc = [0, 0, 0]

    for idx, ans in enumerate(answers):
        if a[idx % 5] == ans:
            abc[0] += 1
        if b[idx % 8] == ans:
            abc[1] += 1
        if c[idx % 10] == ans:
            abc[2] += 1

    best_score = max(abc)

    for idx, score in enumerate(abc):
        if score == best_score:
            answer.append(idx + 1)

    return answer
