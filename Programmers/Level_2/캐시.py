from collections import deque


def solution(cacheSize, cities):
    if cacheSize == 0:
        return 5 * len(cities)

    answer = 0
    cache = deque()

    for city in cities:
        city = city.upper()

        if city not in cache:
            if len(cache) < cacheSize:
                cache.append(city)
            else:
                cache.popleft()
                cache.append(city)

            answer += 5
        else:
            cache.remove(city)
            cache.append(city)

            answer += 1

    return answer
