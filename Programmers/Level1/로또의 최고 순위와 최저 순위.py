def solution(lottos, win_nums):
    count = zeros = 0

    for win_num in win_nums:
        if win_num in lottos:
            count += 1

    for lotto in lottos:
        if lotto == 0:
            zeros += 1

    answers = []

    answers.append(7 - count - zeros if count != 0 or zeros != 0 else 6)
    answers.append(7 - count if count != 0 else 6)

    return answers
