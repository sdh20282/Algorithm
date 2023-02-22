def solution(lines):
    times = []
    answer = 1

    for line in lines:
        line = line.split()
        hour, minute, second = map(float, line[1].split(':'))
        working_time = float(line[2][:-1])

        end_time = hour * 3600 + minute * 60 + second
        start_time = end_time - working_time + 0.001

        times.append([start_time, end_time])

    for i in range(len(times) - 1):
        count = 1

        for j in range(i + 1, len(times)):
            if times[j][0] < times[i][1] + 1:
                count += 1

        if answer < count:
            answer = count

    return answer
