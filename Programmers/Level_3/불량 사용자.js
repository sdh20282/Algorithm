function solution(user_id, banned_id) {
    let result = 0;
    const permutation = Array(banned_id.length);
    const visited = Array(user_id.length).fill(false);
    const set = new Set();

    const check = (per, ban) => {
        per = per.map(i => user_id[i]).sort((a, b) => a.length - b.length);
        ban.sort((a, b) => a.length - b.length);

        for (let i = 0; i < per.length; i++) {
            if (per[i].length != ban[i].length) {
                return false;
            }

            if (!per[i].match(new RegExp(ban[i].replaceAll('*', '.')))) {
                return false;
            }
        }

        return true;
    }

    const dfs = (cur) => {
        if (cur == banned_id.length) {
            if (check(permutation, banned_id)) {
                set.add(permutation.map(i => user_id[i]).sort().join(''));
            }

            return;
        }

        for (let i = 0; i < user_id.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            permutation[cur] = i
            dfs(cur + 1);
            visited[i] = false;
        }
    }

    dfs(0);

    return set.size;
}
