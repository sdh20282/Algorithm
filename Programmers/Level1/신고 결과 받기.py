def solution(id_list, reports, k):
    info = {}

    for iD in id_list:
        info[iD] = [0, [], 0]

    for report in reports:
        report_from, report_to = report.split()

        user_info = info.get(report_to)

        if report_from in user_info[1]:
            continue

        user_info[0] += 1
        user_info[1].append(report_from)
        info[report_to] = user_info

    for user in info:
        user_info = info.get(user)

        if user_info[0] >= k:
            for reporter in user_info[1]:
                reporter_info = info.get(reporter)
                reporter_info[2] += 1
                info[reporter] = reporter_info

    answer = []

    for user in info:
        user_info = info.get(user)
        answer.append(user_info[2])

    return answer
