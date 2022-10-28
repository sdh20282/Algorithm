import heapq


def solution(jobs):
    jobs.sort(key=lambda x: x[0])
    required_times = {}

    for job in jobs:
        j = required_times.get(job[0], [])
        j.append(job[1])
        required_times[job[0]] = j

    heap = []
    total = request_time = prev_request_time = 0

    while required_times:
        for time in range(prev_request_time, request_time + 1):
            if time in required_times:
                now_required_times = required_times.pop(time)

                for now_required_time in now_required_times:
                    heapq.heappush(heap, [now_required_time, time])

        prev_request_time = request_time

        if not heap:
            request_time += 1
            continue

        now = heapq.heappop(heap)
        total += now[0] + request_time - now[1]
        request_time += now[0]

    while heap:
        now = heapq.heappop(heap)
        total += now[0] + request_time - now[1]
        request_time += now[0]

    return int(total / len(jobs))
