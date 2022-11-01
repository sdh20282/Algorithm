import re


def solution(dartResult):
    tries = re.findall(r'([0-9]|10)([SDT])([*#]?)', dartResult)
    bonuses = {'S': 1, 'D': 2, 'T': 3}
    options = {'' : 1, '*' : 2, '#' : -1}
    answer = []

    for i in range(len(tries)):
        if tries[i][2] == '*' and i > 0:
            answer[i-1] *= 2
        answer.append(int(tries[i][0]) ** bonuses[tries[i][1]] * options[tries[i][2]])

    return sum(answer)
