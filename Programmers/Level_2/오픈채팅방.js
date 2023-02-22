function solution(records) {
    const answer = [];
    const nicknames = {};

    for (const record of records) {
        const rec = record.split(' ');
        
        if (rec[0] != 'Leave') {
            nicknames[rec[1]] = rec[2]
        }
    }

    for (const record of records) {
        const rec = record.split(' ');
        
        if (rec[0] == 'Enter') {
            answer.push(nicknames[rec[1]] + '님이 들어왔습니다.');
        } else if (rec[0] == 'Leave') {
            answer.push(nicknames[rec[1]] + '님이 나갔습니다.');
        }
    }

    return answer;
}
