def solution(clothes):
    hash_map = {}

    for cloth, kind in clothes:
        hash_map[kind] = hash_map.get(kind, 0) + 1

    answer = 1

    for kind in hash_map:
        answer *= (hash_map[kind] + 1)

    return answer - 1
