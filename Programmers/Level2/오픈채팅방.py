def solution(records):
    answer = []
    nicknames = {}

    for record in records:
        rec = record.split()

        if rec[0] != 'Leave':
            nicknames[rec[1]] = rec[2]

        if rec[0] == 'Enter':
            answer.append([rec[1], '님이 들어왔습니다.'])
        elif rec[0] == 'Leave':
            answer.append([rec[1], '님이 나갔습니다.'])

    for i in range(len(answer)):
        answer[i][0] = nicknames[answer[i][0]]
        answer[i] = ''.join(answer[i])

    return answer
