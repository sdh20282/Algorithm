def solution(name):
    answer = 0

    min_move = 0

    for i in range(len(name) - 1, 0, -1):
        if name[i] != 'A':
            min_move = i
            break

    for idx, character in enumerate(name):
        answer += min(ord(character) - ord('A'), ord('Z') - ord(character) + 1)

        left_farthest_position = 0

        for i in range(idx + 1, len(name)):
            if name[i] != 'A':
                left_farthest_position = i
                break

        min_move = min(min_move, len(name) - left_farthest_position + idx + idx, 2 * (len(name) - left_farthest_position) + idx)

    return answer + min_move
