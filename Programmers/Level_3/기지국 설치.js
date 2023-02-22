function solution(n, stations, w) {
    let answer = 0, stationIndex = 0, now = 1, station;
    station = stations[stationIndex];

    while (now <= n) {
        if (now >= station - w && now <= station + w) {
            now = station + w + 1;
            station = stations[++stationIndex];
        } else {
            now += 2 * w + 1;
            answer += 1;
        }
    }

    return answer;
}
