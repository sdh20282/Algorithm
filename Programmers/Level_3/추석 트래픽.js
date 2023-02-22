function solution(lines) {
    const times = [];
    let answer = 1;

    for (let line of lines) {
        let hour, minute, second, working_time;

        line = line.split(' ');
        [hour, minute, second]  = line[1].split(':').map(i => parseFloat(i));
        working_time = parseFloat(line[2].slice(0, -1));

        const end_time = hour * 3600 + minute * 60 + second;
        const start_time = end_time - working_time + 0.001;
        
        times.push([start_time, end_time]);
    }

    for (let i = 0; i < times.length - 1; i++) {
        let count = 1;

        for (let j = i + 1; j < times.length; j++) {
            if (times[j][0] < times[i][1] + 1) {
                count += 1;
            }
            
            if (answer < count) {
                answer = count
            }
        }
    }

    return answer;
}
