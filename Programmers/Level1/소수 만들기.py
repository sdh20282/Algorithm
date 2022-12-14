def solution(nums):
    answer = 0

    for i in range(len(nums) - 2):
        for j in range(i + 1, len(nums) - 1):
            for k in range(j + 1, len(nums)):
                now = nums[i] + nums[j] + nums[k]
                is_minority = True

                for l in range(2, now):
                    if now % l == 0:
                        is_minority = False
                        break

                if is_minority:
                    answer += 1

    return answer
