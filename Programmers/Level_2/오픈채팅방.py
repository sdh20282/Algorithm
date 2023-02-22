def solution(records):
    answer = []
    nicknames = {}

    for record in records:
        rec = record.split()

        if rec[0] != 'Leave':
            nicknames[rec[1]] = rec[2]

    for record in records:
        record = record.split(' ')

        if record[0] == 'Enter':
            answer.append(nicknames[record[1]] + '님이 들어왔습니다.')
        elif record[0] == 'Leave':
            answer.append(nicknames[record[1]] + '님이 나갔습니다.')

    return answer
