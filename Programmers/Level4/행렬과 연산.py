from collections import deque


def solution(rc, operations):
    row = len(rc)
    col = len(rc[0])

    left = deque()
    right = deque()
    body = deque()

    for r in rc:
        left.append(r[0])
        body.append(deque(r[1 : col - 1]))
        right.append(r[col - 1])

    top = body.popleft()
    bottom = body.pop()

    for operation in operations:
        if operation == "Rotate":
            top.appendleft(left.popleft())
            right.appendleft(top.pop())
            bottom.append(right.pop())
            left.append(bottom.popleft())
        if operation == "ShiftRow":
            left.appendleft(left.pop())
            right.appendleft(right.pop())
            body.appendleft(top)
            top = bottom
            bottom = body.pop()

    body.appendleft(top)
    body.append(bottom)

    for i in range(row):
        rc[i][0] = left[i]
        rc[i][1 : col - 1] = body[i]
        rc[i][col - 1] = right[i]

    return rc
