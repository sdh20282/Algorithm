def solution(s):
    result = []

    for i in range(1, (len(s)//2) + 1):
        count = 1
        fixed_string = ''

        for j in range(0, len(s), i):
            if s[j:j + i] == s[j + i:j + i + i]:
                count += 1
                now = s[j:j + i]
            elif count > 1:
                fixed_string += str(count) + now
                count = 1
            else:
                fixed_string += s[j:j + i]

        result.append(len(fixed_string))

    return 1 if not result else min(result)
