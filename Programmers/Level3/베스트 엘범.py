def solution(genres, plays):
    hash_map = {}

    for i in range(len(genres)):
        now = hash_map.get(genres[i], [0, -1, -1, -1, -1])
        now[0] += plays[i]

        if now[2] < plays[i] or (now[2] == plays[i] and now[1] > i):
            now[3:5] = now[1:3]
            now[1], now[2] = i, plays[i]
        elif now[4] < plays[i] or (now[4] == plays[i] and now[3] > i):
            now[3], now[4] = i, plays[i]

        hash_map[genres[i]] = now

    hash_map = sorted(hash_map.items(), key=lambda x: x[1][0], reverse=True)

    answer = []

    for genre_info in hash_map:
        if genre_info[1][1] != -1:
            answer.append(genre_info[1][1])
        if genre_info[1][3] != -1:
            answer.append(genre_info[1][3])

    return answer
