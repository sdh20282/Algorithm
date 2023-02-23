function solution(gems) {
    const n = new Set(gems).size;
    const map = new Map();
    let section = [1, gems.length];
    let left = 0, right = 0;

    while (right < gems.length || map.size == n) {
        if (map.size == n) {
            if (right - left <= section[1] - section[0]) {
                section = [left + 1, right];
            }

            if (map.get(gems[left]) == 1) {
                map.delete(gems[left]);
            } else {
                map.set(gems[left], map.get(gems[left]) - 1);
            }

            
            left += 1;
        } else {
            map.set(gems[right], map.get(gems[right]) ? map.get(gems[right]) + 1 : 1);
            right += 1;
        }
    }

    return section;
}
