def solution(s):
    stack = []

    for char in s:
        if not stack:
            stack.append(char)
            continue

        if stack[-1] == '(' and char == ')':
            stack.pop()
        else:
            stack.append(char)

    if not stack:
        return True

    return False
