def solution(triangle):
    now_stage = triangle[0]

    for stage in range(1, len(triangle)):
        sum_stage = [0 for _ in range(stage + 1)]

        for idx, element in enumerate(now_stage):
            if element + triangle[stage][idx] > sum_stage[idx]:
                sum_stage[idx] = element + triangle[stage][idx]
            if element + triangle[stage][idx + 1] > sum_stage[idx + 1]:
                sum_stage[idx + 1] = element + triangle[stage][idx + 1]

        now_stage = sum_stage

    return max(now_stage)
