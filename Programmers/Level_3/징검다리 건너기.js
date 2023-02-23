function solution(stones, k) {
    let left = 0; right = 200000000;

    while (left <= right) {
        let mid = Math.floor((left + right) / 2), count = 0;

        for (const stone of stones) {
            if (stone - mid <= 0) {
                count += 1;
            } else {
                count = 0;
            }

            if (count === k) {
                break;
            }
        }

        if (count === k) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return left;
}
