def solution(arr):
    values = [0, 0]
    min_val = 0
    max_val = 1

    idx = len(arr) - 1
    plus_sum = 0

    while idx >= 0:
        if arr[idx] != "-" and arr[idx] != "+":
            plus_sum += int(arr[idx])

        elif arr[idx] == "-":
            tmp = values.copy()

            values[min_val] = min(-(tmp[max_val] + plus_sum), tmp[min_val] - plus_sum)
            values[max_val] = max(-(tmp[min_val] + plus_sum), tmp[max_val] + plus_sum - (2 * int(arr[idx + 1])))

            plus_sum = 0

        idx -= 1

    return values[max_val] + plus_sum
