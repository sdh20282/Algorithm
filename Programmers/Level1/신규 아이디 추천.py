def solution(new_id):
    transform = []

    for word in new_id:
        if 65 <= ord(word) <= 90:
            transform.append(chr(ord(word) + 32))
        elif 97 <= ord(word) <= 122 or 48 <= ord(word) <= 57 or word == '-' or word == '_':
            transform.append(word)
        elif word == '.':
            if len(transform) == 0 or transform[len(transform) - 1] == '.':
                continue
            transform.append(word)

    transform = transform[:15]

    if len(transform) == 0:
        transform.append('a')

    if transform[len(transform) - 1] == '.':
        transform = transform[:-1]

    if len(transform) < 3:
        last = transform[len(transform) - 1]

        while len(transform) < 3:
            transform.append(last)

    return ''.join(transform)
