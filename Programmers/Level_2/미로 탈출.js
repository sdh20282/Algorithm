class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class Queue {
    constructor() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    add(node) {
        if (this.size == 0) {
            this.start = node;
            this.end = node;
        } else {
            this.end.next = node;
            this.end = node;
        }

        this.size += 1;
    }

    pop() {
        if (this.size == 0) {
            return null;
        } else {
            const temp = this.start;
            this.start = this.start.next;
            this.size -= 1;

            return temp;
        }
    }

    length() {
        return this.size;
    }

    print() {
        let temp = this.start;

        while (temp != null) {
            console.log(temp.value);
            temp = temp.next;
        }
    }
}

function solution(maps) {
    const n = maps.length, m = maps[0].length;
    const visited = [Array(n).fill(0).map(e => Array(m).fill(false)), Array(n).fill(0).map(e => Array(m).fill(false))];
    const dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]];
    let sr = 0, sc = 0, mins = [Infinity, Infinity], target = ["L", "E"];

    for (let i = 0; i < n; i++) {
        maps[i] = maps[i].split('');

        for (let j = 0; j < m; j++) {
            if (maps[i][j] === "S") {
                sr = i;
                sc = j;
            }
        }
    }
    
    let queue = new Queue();

    for (let i = 0; i < 2; i++) {
        queue.add(new Node([sr, sc, 0]));

        while (queue.length() > 0) {
            let [nr, nc, count] = queue.pop().value;
            
            if (visited[i][nr][nc]) {
                continue;
            }

            visited[i][nr][nc] = true;

            if (maps[nr][nc] === target[i]) {
                sr = nr;
                sc = nc;
                mins[i] = count;
                queue = new Queue();

                break;
            }

            for (const dir of dirs) {
                let [dr, dc] = dir;

                if (nr + dr < 0 || nr + dr >= n || nc + dc < 0 || nc + dc >= m) {
                    continue;
                }

                if (maps[nr + dr][nc + dc] == "X" || visited[i][nr + dr][nc + dc]) {
                    continue;
                }

                queue.add(new Node([nr + dr, nc + dc, count + 1]));
            }
        }
    }

    return mins[0] == Infinity || mins[1] == Infinity ? -1 : mins[0] + mins[1];
}
