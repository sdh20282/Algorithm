class Queue {
    constructor() {
        this.storage = {};
        this.front = 0;
        this.rear = 0;
    }

    size() {
        if (this.storage[this.rear] === undefined) {
            return 0;
        } else {
            return this.rear - this.rear + 1;
        }
    }

    add(value) {
        if (this.size() === 0) {
            this.storage['0'] = value;
        } else {
            this.rear += 1;
            this.storage[this.rear] = value;
        }
    }

    popleft() {
        let temp;
        if (this.front === this.rear) {
            temp = this.storage[this.front];
            delete this.storage[this.front];
            this.front = 0;
            this.rear = 0;
        } else {
            temp = this.storage[this.front];
            delete this.storage[this.front];
            this.front += 1;
        }
        return temp;
    }
}

function solution(numbers, target) {
    let answer = 0;
    const q = new Queue();

    q.add([0, 0])

    while (q.size()) {
        [total, index] = q.popleft();

        if (index > numbers.length) {
            continue
        }

        if (index == numbers.length) {
            if (total == target) {
                answer++;
            }

            continue;
        }

        q.add([total + numbers[index], index + 1]);
        q.add([total - numbers[index], index + 1]);
    }


    return answer;
}
